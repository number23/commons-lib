(ns org.clojars.number23.commons-lib.sha)

(defn ^String sha-str
  "Return a string, the default algorithms is SHA1,
   others: MD5, SHA-256, SHA-512 etc."
  ([^String s] (sha-str "SHA1" s))
  ([^String algorithm ^String s]
     (->> (-> algorithm
              java.security.MessageDigest/getInstance
              (.digest (.getBytes s)))
          (map #(.substring
                 (Integer/toString
                  (+ (bit-and % 0xff) 0x100) 16) 1))
          (apply str))))


