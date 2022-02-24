(ns currency-converter.formatter)

(defn format-currency [currency from to]
  (str "1 " from " equals " currency " in " to))