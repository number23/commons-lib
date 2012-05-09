(defproject de.no.number23/commons-lib "0.0.4"
  :description "my clojure commons lib"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [javax.mail/mail "1.4.5"]]
  :dev-dependencies [[codox "0.6.1"]
                     [lein-clojars "0.8.0"]]

  :main de.no.number23.commons-lib.core
  :aot :all
  :jvm-opts ["-Xmx1g"])
