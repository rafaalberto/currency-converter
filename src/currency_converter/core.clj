(ns currency-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def options
  [["-f" "--from currency base" "From Currency" :default "BRL"]
   ["-t" "--to currency base" "To Currency" :default "USD"]])

(defn -main
  "Calling static main function"
  [& args]
  (println "Arguments are: " (:options (parse-opts args options))))
