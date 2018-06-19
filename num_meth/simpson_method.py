from integral import IntegralInfo


class Simpson:
    def __init__(self, n):
        self.ii = IntegralInfo()
        self.n = n

    def solve(self):
        n = self.n

        h = (self.ii.b - self.ii.a) / n
        x = list()
        x.append(self.ii.a)
        for i in range(1, n):
            x.append(x[-1] + h)
        y = [self.ii.solve(x[i]) for i in range(0, len(x))]

        y_odd = [y[i] for i in range(1, len(y) - 1, 2)]
        y_even = [y[i] for i in range(2, len(y) - 1, 2)]
        result = h / 3 * (y[0] + y[-1] + 4 * sum(y_odd) + 2 * sum(y_even))

        return {
            "n": n,
            "result": result,
        }
