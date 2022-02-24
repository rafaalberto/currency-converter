(ns currency-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require [clj-http.client :as http-client])
  (:gen-class))

(def options
  [["-f" "--from currency base" "From Currency" :default "BRL"]
   ["-t" "--to currency base" "To Currency" :default "USD"]])

(def api-url "https://free.currconv.com/api/v7/convert")

(defn set-currency [from to]
  (str from "_" to))

(def api-key "b53bc913399a901b3544")

(defn -main
  "Calling static main function"
  [& args]
  (let [{:keys [from to]} (:options (parse-opts args options))]
    (prn "Http execute: " (http-client/get api-url
                                           {:query-params {"q"      (set-currency from to)
                                                           "apiKey" api-key}}))))
