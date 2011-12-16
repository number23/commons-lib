(defproject org.clojars.number23_cn/commons-lib "1.0.0"
  :description "commons lib"
  :dependencies [[org.clojure/clojure "1.3.0"]]
  :dev-dependencies [[codox "0.3.0"]
                     [lein-clojars "0.7.0"]]

  :main org.clojars.number23_cn.commons-lib.core
  :aot [org.clojars.number23_cn.commons-lib.io
        org.clojars.number23_cn.commons-lib.util]
  )
