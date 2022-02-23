(ns currency-converter.core
  (:gen-class))

(defn -main
  "Calling static main function"
  [& args]
  (println "We have " (count args) " argument(s)")
  (println "Arguments are: " args))
