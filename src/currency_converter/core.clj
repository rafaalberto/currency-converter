(ns currency-converter.core
  (:require [currency-converter.options-reader :refer [read-options]])
  (:require [currency-converter.converter-client :refer [get-price]])
  (:require [currency-converter.formatter :refer [format-currency]])
  (:gen-class))

(defn -main [& args]
  (let [{:keys [from to]} (read-options args)]
    (-> (get-price from to)
        (format-currency from to)
        (prn))))