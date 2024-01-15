(defn fib
  ([]
   (fib 0 1))
  ([n m]
   (lazy-seq (cons n (fib m (+ n m))))))


(take 5 (fib))


(defn fibn
  [n]
  (take n (fib)))


(defn eager-fib
  [n]
  (loop [remaining n
         res []
         cur 0
         prev 0]
    (cond
      (< remaining 1) res
      (= cur 0) (recur (dec remaining) (conj res cur) 1 0)
      :else (recur (dec remaining) (conj res cur) (+ cur prev) cur))))


(dec 0)

(eager-fib 0)
(eager-fib 1)
(eager-fib 5)


(fibn 5)

(= (take 7 (fib)) '(0 1 1 2 3 5 8))
