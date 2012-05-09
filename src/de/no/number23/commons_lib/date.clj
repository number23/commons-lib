(ns de.no.number23.commons-lib.date
  (:import (java.util Calendar Date)))

(defn get-Monday
  "as name, return Monday"
  [^Date d]
  (let [cal (Calendar/getInstance)]
    (.setTime cal d)
    (let [dt (- (.get cal Calendar/DAY_OF_WEEK) 2)]
      (.add cal Calendar/DATE (- dt))
      (.getTime cal))))

(defn cdts
  "return current datetime string: yyyy-MM-dd HH:mm:ss"
  []
  (format "%1$tF %1$tT" (Date.)))
