(defn odds-only
  [s]
  (lazy-seq
    (when-let [s (seq s)]
      (if (= (mod (first s) 2) 1)
        (cons (first s) (odds-only (rest s)))
        (odds-only (rest s))))))


(odds-only [])
(odds-only [1])
(odds-only [2])
(odds-only [2 1])
(= (odds-only [5 0 2 3]) [5 3])
(= (odds-only #{1 2 3 4 5}) '(1 3 5))

