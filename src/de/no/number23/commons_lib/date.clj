(ns de.no.number23.commons-lib.date
  (:import (java.util Calendar Date)))

(defn get-Monday
  "SUNDAY is first day of the week, force it"
  [^Date d]
  (let [cal (Calendar/getInstance)]
    (doto cal
      (.setTime d)
      (.setFirstDayOfWeek (Calendar/SUNDAY)))
    (let [dt (- (.get cal Calendar/DAY_OF_WEEK) 2)]
      (.add cal Calendar/DATE (- dt))
      (.getTime cal))))
