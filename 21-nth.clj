(defn nther
  [s n]
  (cond
    (= n 0) (first s)
    :else (recur (rest s) (- n 1))))





(and
  (= (nther [] 1) nil)
  (= (nther [1] 0) 1)
  (= (nther [1 2] 1) 2))
