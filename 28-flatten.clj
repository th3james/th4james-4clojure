(defn flattr
  [s]
  (lazy-seq
    (when-let [s (seq s)]
      (if (sequential? (first s))
        (concat (flattr (first s)) (flattr (rest s)))
        (cons (first s) (flattr (rest s)))))))


(defn eager-flattr
  [in]
  (loop [result [] in in]
    (cond
      (sequential? (first in)) (recur result (concat (first in) (rest in)))
      (seq in) (recur (conj result (first in)) (rest in))
      :else result)))


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
