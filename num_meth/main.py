from flask import Flask, render_template, request
from simpson_method import Simpson
from romberg_algorithm import Romberg
from romberg_algorithm2 import Romberg2, main_func

app = Flask(__name__)

@app.route('/')
def start():
   return "<h1>Lab2_3</h1>"

@app.route('/simpson_method',methods = ['POST', 'GET'])
def simpson_method():
    if request.method == 'GET':
        return render_template("simpson_method.html")

    if request.method == 'POST':
        num_interv_simp = request.form['num_interv_simp']
        sn = Simpson(n=int(num_interv_simp))
        infoS = sn.solve()
        simpson = {
            "result": infoS['result'],
            "n": infoS['n'],
        }
        return render_template("simpson_method.html", simpson = simpson)

@app.route('/romberg_algorithm',methods = ['POST', 'GET'])
def romberg_algorithm():
    if request.method == 'GET':
        return render_template("romberg_algorithm.html")

    if request.method == 'POST':
        rg = Romberg(int(-9))
        infoR = rg.solve(10)
        romberg = {
            "result": infoR['final_array'],
            "final_step": infoR['final_step'],
            "r_hi_val" : infoR['h_i']
        }
        return render_template("romberg_algorithm.html", romberg = romberg)

@app.route('/romberg_algorithm2',methods = ['POST', 'GET'])
def romberg_algorithm2():
    if request.method == 'GET':
        return render_template("romberg_algorithm2.html")

    if request.method == 'POST':
        rg = Romberg2(main_func, -9)
        infoR = rg.integral(1, 3, 10)
        print(infoR['final_array'])
        romberg = {
            "result": infoR['final_array'],
            "final_step": infoR['final_step'],
            "r_hi_val" : infoR['r_kminus1_hi_values']
        }
        return render_template("romberg_algorithm2.html", romberg = romberg)

if __name__ == '__main__':
    app.run(debug = True)
