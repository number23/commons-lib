(defproject de.no.number23/commons-lib "0.0.3"
  :description "my clojure commons lib"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [javax.mail/mail "1.4.4"]]
  :dev-dependencies [[codox "0.3.0"]
                     [lein-clojars "0.7.0"]]

  :main de.no.number23.commons-lib.core
  :aot [de.no.number23.commons-lib.io
        de.no.number23.commons-lib.util
        de.no.number23.commons-lib.mail])
