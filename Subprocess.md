## Subprocess
[Download](Subprocess.py)
	# -*- coding: utf-8 -*-
	"""
	Created on Sun Feb 18 22:58:24 2018

	@author: Ho Yu Hin
	"""

	import subprocess

	try:
	    file = open('data.txt', 'r+')
	except Exception as e:
	    print('no such file exists, it is created now')
	    file = open('data.txt','w')
	file.close()

	command = 'java Test'
	p = command + " >> data.txt"
	subprocess.call(p, shell=True)
