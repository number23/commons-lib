(ns de.no.number23.commons-lib.date
  (:import (java.util Calendar Date)))

(defn get-Monday
  [^Date d]
  (let [cal (Calendar/getInstance)]
    (.setTime cal d)
    (let [dt (- (.get cal Calendar/DAY_OF_WEEK) 2)]
      (.add cal Calendar/DATE (- dt))
      (.getTime cal))))
