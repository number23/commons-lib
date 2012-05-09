(ns de.no.number23.commons-lib.stacktrace
  (:use [clojure.repl :only (root-cause stack-element-str)]))

(defn pst12
  "return a stack trace of the exception, to the depth requested.
  If none supplied, uses the root cause of the most recent repl exception (*e),
  and a depth of 12.

  source code copy from clojure.repl.pst
  "

  ([] (pst12 12))
  ([e-or-depth]
     (if (instance? Throwable e-or-depth)
       (pst12 e-or-depth 12)
       (when-let [e *e]
         (pst12 (root-cause e) e-or-depth))))
  ([^Throwable e depth]
     (let [s (StringBuilder.)]
       (.append s (str (-> e class .getSimpleName) " "
                       (.getMessage e)
                       (when-let [info (ex-data e)] (str " " (pr-str info))) "\n"))
       (let [st (.getStackTrace e)
             cause (.getCause e)]
         (doseq [el (take depth
                          (remove #(#{"clojure.lang.RestFn" "clojure.lang.AFn"} (.getClassName %))
                                  st))]
           (.append s (str \tab (stack-element-str el) "\n")))
         (when cause
           (-> s
               (.append "Caused by:\n")
               (.append (pst12 cause (min depth
                                          (+ 2 (- (count (.getStackTrace cause))
                                                  (count st)))))))))
       (str s))))
