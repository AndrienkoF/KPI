import math
import numpy


def main_func(x):
    return 1 / ((2 ** x) + 3)

class Romberg2(object):
    def __init__(self, integral_func, epsilon_pwr):
        self.func = integral_func
        self.epsilon_pwr = epsilon_pwr

    def integral(self, a_start, b_end, n_max):  # n_max: maximal levels of recursion
        r_kminus1_hi_holder = list()
        h_i = []
        main_array = numpy.array([[0] * (n_max + 1)] * (n_max + 1), float)
        h = b_end - a_start  # h0
        main_array[0, 0] = 0.5 * h * (self.func(a_start) + self.func(b_end))
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
                sum += self.func(a_start + k * h)

            # Compute the composite trapezoid rule for the next level of subdivision.
            # Use Richardson extrapolation to make these values more accurate.
            main_array[i, 0] = 0.5 * main_array[i - 1, 0] + sum * h

            power_of_4 = 1
            for j in range(1, i + 1):
                power_of_4 = 4 * power_of_4
                r_kminus1_hi = (main_array[i, j - 1] - main_array[i - 1, j - 1]) / (power_of_4 - 1)
                print(r_kminus1_hi)
                r_kminus1_hi_holder.append(r_kminus1_hi)
                main_array[i, j] = main_array[i, j - 1] + r_kminus1_hi
                if math.fabs(r_kminus1_hi) <= math.pow(10, -10):
                    main_array_jsonify = main_array.tolist()
                    return {
                        'final_step': i + 1,
                        'r_kminus1_hi_values': h_i,
                        'final_array': main_array_jsonify
                    }
