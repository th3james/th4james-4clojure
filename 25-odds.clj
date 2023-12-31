(defn odds-only
  ([s]
   (odds-only s []))
  ([s res]
   (cond
     (empty? s) res
     (= (mod (first s) 2) 1) (recur (rest s) (conj res (first s)))
     :else (recur (rest s) res))))


(odds-only [])
(odds-only [1])
(odds-only [2])
(odds-only [2 1])
(= (odds-only [5 0 2 3]) [5 3])
(= (odds-only #{1 2 3 4 5}) '(1 3 5))

