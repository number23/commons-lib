(ns org.clojars.number23.commons-lib.io
  (:require [clojure.java.io :as io]))

(defn ^String prompt-read
  "return String
  from http://thinkrelevance.com/blog/2008/09/16/pcl-clojure-chapter-3.html"
  [^String prompt]
  (print (format "%s: " prompt))
  (flush)
  (read-line))

(defn y-or-n
  "return true if input y, n return false
  from http://thinkrelevance.com/blog/2008/09/16/pcl-clojure-chapter-3.html"
  [^String prompt]
  (= "y"
     (loop []
       (or
        (re-matches #"[yn]" (.toLowerCase (prompt-read prompt)))
        (recur)))))

(defn prompt-re
  "re is Pattern, return the match"
  [^String prompt ^java.util.regex.Pattern re]
  (loop []
    (or
     (re-matches re (prompt-read prompt))
     (recur))))

(defn processing-file
  "process a file by line with func"
  [file func]
  (with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (func line))))

(defmacro with-err-str
  "Evaluates exprs in a context in which *err* is bound to a fresh
  StringWriter.  Returns the string created by any nested printing
  calls."
  [& body]
  `(let [s# (new java.io.StringWriter)]
     (binding [*err* s#]
       ~@body
       (str s#))))

(defn parse-int "parse string into int" [^String s] (Integer/parseInt s))
(defn split-str-with-comma "return a vec" [^String s] (vec (.split s ",")))
