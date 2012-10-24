(ns org.clojars.number23.commons-lib.mail)

(defn sendmail
  "simple sendmail function by smtp protocol,
  base on javax.mail, keys:
  host, port, user, password,
  auth, ssl,
  debug,
  from, to, cc, bcc,
  subject, text, content

  if debug is true, debug output, send to bcc only,
  from is String, to, cc, and bcc is vec,
  if text is setup, send text/plan msg
  content is javax.mail.Multipart

  usag:

  (sendmail
    :host \"smtp.gmail.com\"
    :user \"number23.cn@gmail.com\"
    :password \"secret_password\"
    :port \"587\"
    :auth true
    :ssl true
    :debug false
    :from \"number23.cn@gmail.com\"
    :to [\"number23.cn@gmail.com\"]
    :subject \"Sendmail by Clojure\"
    :text \"Test\")

  with Multipart:

  (import 'javax.mail.internet.MimeMultipart)
  (import 'javax.mail.internet.MimeBodyPart)

  (let [mp (MimeMultipart.)
        hp (MimeBodyPart.)]
    (.setContent hp \"<H1>Hello Clojure</H1>\" \"text/html\")
    (.addBodyPart mp hp)

    (sendmail
      :content mp
      ...))"

  [& m]
  (let [mail (apply hash-map m)
        props (java.util.Properties.)]

    (doto props
      (.put "mail.smtp.host" (:host mail))
      (.put "mail.smtp.port" (:port mail))
      (.put "mail.smtp.user" (:user mail ""))
      (.put "mail.smtp.socketFactory.port"  (:port mail)))

    (if (= (:auth mail false) true)
      (do
        (.put props "mail.smtp.auth" "true")
        (if (= (:ssl mail) true)
          (doto props
            (.put "mail.smtp.starttls.enable" "true")
            (.put "mail.smtp.socketFactory.fallback" "false")))))


    (let [authenticator (proxy [javax.mail.Authenticator] []
                          (getPasswordAuthentication
                            []
                            (javax.mail.PasswordAuthentication.
                             (:user mail "") (:password mail ""))))

          to (if (:to mail) (reduce #(str % "," %2) (:to mail)) nil)
          cc (if (:cc mail) (reduce #(str % "," %2) (:cc mail)) nil)
          bcc (if (:bcc mail) (reduce #(str % "," %2) (:bcc mail)) nil)

          session (javax.mail.Session/getInstance props authenticator)
          msg     (javax.mail.internet.MimeMessage. session)]

      (if (= (:debug mail) true) (.setDebug session true))
      (.setFrom msg (javax.mail.internet.InternetAddress. (:from mail)))

      (if (= (:debug mail) true)
        (.setRecipients msg
                        (javax.mail.Message$RecipientType/TO)
                        (javax.mail.internet.InternetAddress/parse bcc))
        (do
          (.setRecipients msg
                          (javax.mail.Message$RecipientType/TO)
                          (javax.mail.internet.InternetAddress/parse to))
          (if cc (.setRecipients msg
                                 (javax.mail.Message$RecipientType/CC)
                                 (javax.mail.internet.InternetAddress/parse cc)))
          (if bcc (.setRecipients msg
                                  (javax.mail.Message$RecipientType/BCC)
                                  (javax.mail.internet.InternetAddress/parse bcc)))))

      (.setSubject msg (:subject mail))
      (if (:text mail nil)
        (.setText msg (:text mail))
        (.setContent msg (:content mail)))
      (javax.mail.Transport/send msg))))

(defn fill-msg-content
  "fill message content with text and files,
  return java.mail.internet.MimeMultipart"

  [^String text & files]
  (let [mmp (javax.mail.internet.MimeMultipart.)
        mbp (javax.mail.internet.MimeBodyPart.)
        sbuf (StringBuilder.)]
    (-> sbuf
        (.append "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><pre>")
        (.append text)
        (.append "</pre></body></html>"))
    (.setContent mbp (.toString sbuf) "text/html; charset=utf-8")
    (.setHeader mbp "Content-Transfer-Encoding" "base64")
    (.addBodyPart mmp mbp)

    (letfn [(add-part [^String f]
              (let [part (javax.mail.internet.MimeBodyPart.)]
                (.attachFile part f)
                (.setHeader part "Content-Transfer-Encoding" "base64")
                (.addBodyPart mmp part)))]
      (doseq [file files]
        (when-let [x file]
          (if (sequential? x)
            (doseq [f x] (add-part f))
            (add-part x)))))
    mmp))
