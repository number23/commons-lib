(ns org.clojars.number23_cn.commons-lib.io)

(defn prompt-read
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
  (re-matches re (loop []
                   (or
                    (re-matches re (prompt-read prompt))
                    (recur)))))
