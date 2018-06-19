from integral import IntegralInfo
import math
import numpy

class Romberg():
    def __init__(self, epsilon_pwr):
        self.ii = IntegralInfo()
        self.epsilon_pwr = epsilon_pwr

    def solve(self, n_max):  # n_max: maximal levels of recursion
        r_kminus1_hi_holder = list()
        h_i = []
        main_array = numpy.array([[0] * (n_max + 1)] * (n_max + 1), float)
        h = self.ii.b - self.ii.a  # h0
        main_array[0, 0] = 0.5 * h * (self.ii.solve(self.ii.a) + self.ii.solve(self.ii.b))
        power_of_2 = 1
        i = 0
        h_i.append(h)
        while True:
            i += 1

            # Update stepsize: halve it.
            # Use updated h to sum at all the new points (in between the points already computed)
            h = 0.5 * h
            h_i.append(h)

            sum = 0.0
            power_of_2 = 2 * power_of_2
            for k in range(1, power_of_2, 2):
                sum += self.ii.solve(self.ii.a + k * h)

            # Compute the composite trapezoid rule for the next level of subdivision.
            # Use Richardson extrapolation to make these values more accurate.
            main_array[i, 0] = 0.5 * main_array[i - 1, 0] + sum * h

            power_of_4 = 1
            for j in range(1, i + 1):
                power_of_4 = 4 * power_of_4
                r_kminus1_hi = (main_array[i, j - 1] - main_array[i - 1, j - 1]) / (power_of_4 - 1)
                r_kminus1_hi_holder.append(r_kminus1_hi)
                main_array[i, j] = main_array[i, j - 1] + r_kminus1_hi
                if math.fabs(r_kminus1_hi) <= math.pow(math.e, self.epsilon_pwr):
                    main_array_jsonify = main_array.tolist()
                    return {
                        'final_step': i + 1,
                        'h_i': h_i,
                        'final_array': main_array_jsonify
                    }
