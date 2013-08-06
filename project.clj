(defproject org.clojars.number23/commons-lib "0.2.2"
  :description "my clojure commons lib"
  :url "https://github.com/number23/commons-lib"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}

  :dependencies [[org.clojure/clojure "1.4.0"]
                 [javax.mail/mail "1.4.5"]]

  :plugins [[codox "0.6.1"]
            [lein-pprint "1.1.1"]]

  :warn-on-reflection true
  :main org.clojars.number23.commons-lib.core
  :jvm-opts ["-Xmx1g"])
