(defn flattr
  [s]
  (lazy-seq
    (when-let [s (seq s)]
      (if (sequential? (first s))
        (concat (flattr (first s)) (flattr (rest s)))
        (cons (first s) (flattr (rest s)))))))


(defn eager-flattr
  [v]
  (loop [r [] v v]
    (cond
      (sequential? (first v)) (recur r (concat (first v) (rest v)))
      (empty? v) r
      :else (recur (conj (first v) r) (rest v)))))


(defn tests
  [flatfn]
  (and
    (= (take 3 (flatfn '())) '())
    (= (take 3 (flatfn '(1))) '(1))
    (= (take 3 (flatfn '((1)))) '(1))
    (= (take 3 (flatfn '((1) 2))) '(1 2))
    (= (take 3 (flatfn '((1 2) 3))) '(1 2 3))
    (= (take 5 (flatfn '((1 2) (3 4)))) '(1 2 3 4))
    (= (take 5 (flatfn '((1 (2 3)) (4)))) '(1 2 3 4))
    (= (take 5 (flatfn '(1 2 (3 4)))) '(1 2 3 4))))


(tests flattr)
(tests eager-flattr)
