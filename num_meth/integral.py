class IntegralInfo:
    def __init__(self, a=1, b=3):
        self.a = a
        self.b = b

    @staticmethod
    def solve(x):
        return 1 / ((2 ** x) + 3)

    def func_values_borders_sum(self):
        return self.solve(self.a) + self.solve(self.b)
