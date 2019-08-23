## Matplot
[Download](Matplot.py)

	# -*- coding: utf-8 -*-
	"""
	Created on Sun Feb 18 20:51:42 2018

	@author: Ho Yu Hin
	"""

	import matplotlib.pyplot as plt
	import numpy as np
	from mpl_toolkits.mplot3d import Axes3D

	def twoDPlot():
	    x=np.linspace(-3,3,50)
	    y1=2*x
	    y2=x**2

	    plt.figure()
	    plt.plot(x,y1,label='y1')
	    plt.plot(x,y2,color='red',linewidth=1.0,linestyle='--',label='y2')

	    plt.xlim((0,3))
	    plt.ylim((0,3))
	    plt.xlabel('x axis')
	    plt.ylabel('y axis')

	    ax = plt.gca()
	    ax.spines['right'].set_color('none')
	    ax.spines['top'].set_color('none')
	    ax.xaxis.set_ticks_position('bottom')
	    ax.yaxis.set_ticks_position('left')
	    ax.spines['bottom'].set_position(('data',1))
	    ax.spines['left'].set_position(('data',1))

	    plt.legend()
	    plt.show()

	def barPlot():
	    n = 12
	    X = np.arange(n)
	    Y1 = (1 - X / float(n)) * np.random.uniform(0.5, 1.0, n)

	#   edgecolor white to remove the black edge
	    plt.bar(X, +Y1, facecolor='#9999ff', edgecolor='white')

	    for x, y in zip(X, Y1):
	        # ha: horizontal alignment
	        # va: vertical alignment
	        plt.text(x + 0.4, y + 0.05, '%.2f' % y, ha='center', va='bottom')

	    plt.xlim(-.5, n)
	    plt.xticks(())
	    plt.ylim(-0.1, 1.25)
	    plt.yticks(())

	    plt.show()

	def threeDPlot():
	    fig = plt.figure()
	    ax = Axes3D(fig)
	    # X, Y value
	    X = np.arange(-4, 4, 0.25)
	    Y = np.arange(-4, 4, 0.25)
	    X, Y = np.meshgrid(X, Y)
	    R = np.sqrt(X ** 2 + Y ** 2)
	    # height value
	    Z = np.sin(R)

	    ax.plot_surface(X, Y, Z, rstride=1, cstride=1, cmap=plt.get_cmap('rainbow'))
	            #*vmin*        Minimum value to map
	            #*vmax*        Maximum value to map
	    ax.contourf(X, Y, Z, zdir='z', offset=-2, cmap=plt.get_cmap('rainbow'))
	    ax.set_zlim(-2, 2)
	    plt.show()

	def contourPlot():
	    n = 256
	    x = np.linspace(-3, 3, n)
	    y = np.linspace(-3, 3, n)
	    X,Y = np.meshgrid(x, y)

	    plt.contourf(X, Y, f(X, Y), 8, alpha=.7, cmap=plt.cm.hot)

	    C = plt.contour(X, Y, f(X, Y), 8, colors='black', linewidth=.5)

	    plt.clabel(C, inline=True, fontsize=10)

	    plt.xticks(())
	    plt.yticks(())
	    plt.show()
	def f(x,y):
	    return (1 - x / 2 + x**5 + y**3) * np.exp(-x**2 -y**2)

	twoDPlot()
	barPlot()
	threeDPlot()
	contourPlot()
