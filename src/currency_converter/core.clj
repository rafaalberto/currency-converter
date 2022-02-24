(ns currency-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]])
  (:gen-class))

(def options
  [["-f" "--from currency base" "From Currency" :default "BRL"]
   ["-t" "--to currency base" "To Currency" :default "USD"]])

(def api-key "b53bc913399a901b3544")

(def api-url "https://free.currconv.com/api/v7/convert")

(defn set-currency [from to]
  (str from "_" to))

(defn get-price [from to]
  (let [currencies (set-currency from to)]
    (-> (:body (http-client/get api-url
                                {:query-params {"q"      currencies
                                                "apiKey" api-key}}))
        (parse-string)
        (get-in ["results" currencies "val"]))))

(defn format-currency [currency from to]
  (str "1 " from " equals " currency " in " to))

(defn -main
  "Calling static main function"
  [& args]
  (let [{:keys [from to]} (:options (parse-opts args options))]
    (-> (get-price from to)
        (format-currency from to)
        (println))))