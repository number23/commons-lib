(defproject de.no.number23/commons-lib "0.0.4"
  :description "my clojure commons lib"
  :url "https://github.com/number23/commons-lib"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}

  :dependencies [[org.clojure/clojure "1.4.0"]
                 [javax.mail/mail "1.4.5"]]

  :plugins [[codox "0.6.1"]]

  :main de.no.number23.commons-lib.core
  :aot :all
  :jvm-opts ["-Xmx1g"])
