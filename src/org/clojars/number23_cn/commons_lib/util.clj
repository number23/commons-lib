(ns org.clojars.number23_cn.commons-lib.util)

(defn exit
  "exit the program"
  ([] (System/exit 0))
  ([^Long code] (System/exit code)))

(defn quit
  "exit the program"
  ([] (System/exit 0))
  ([^Long code] (System/exit code)))
