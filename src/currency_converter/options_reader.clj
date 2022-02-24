(ns currency-converter.options-reader
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def options
  [["-f" "--from currency base" "From Currency" :default "BRL"]
   ["-t" "--to currency base" "To Currency" :default "USD"]])

(defn read-options [arguments]
  (:options (parse-opts arguments options)))