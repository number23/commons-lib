(ns org.clojars.number23.commons-lib.util)

(defn exit
  "Exit the program."
  ([] (System/exit 0))
  ([^Long code] (System/exit code)))

(defn quit
  "Exit the program."
  ([] (System/exit 0))
  ([^Long code] (System/exit code)))
