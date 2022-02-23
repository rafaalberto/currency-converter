(ns currency-converter.core
  (:gen-class))

(defn values-in [argument]
  (cond
    (.startsWith argument "--from=") {:from (subs argument 7)}
    (.startsWith argument "--to=") {:to (subs argument 5)}
    :else {}))

(defn -main
  "Calling static main function"
  [& args]
  (println "Arguments are: " (map values-in args)))
