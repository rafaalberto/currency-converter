(ns currency-converter.converter-client
  (:require [clj-http.client :as http-client])
  (:require [cheshire.core :refer [parse-string]]))

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