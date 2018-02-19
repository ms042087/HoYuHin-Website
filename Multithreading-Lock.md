## Multithreading-Lock
[Download](Multithreading-Lock.py)

	# -*- coding: utf-8 -*-
	"""
	Created on Sun Feb 18 12:44:27 2018

	@author: Ho Yu Hin
	"""

	import threading

	def job1():
	    global sharedData,lock

	    lock.acquire()
	    for i in range(10):
	        sharedData +=1
	        print('t1', sharedData)
	    lock.release()

	def job2():
	    global sharedData,lock

	    lock.acquire()
	    for i in range(10):
	        sharedData -=1
	        print('t2', sharedData)
	    lock.release()

	if __name__ == '__main__':
	    lock = threading.Lock()
	    sharedData=0
	    t1 = threading.Thread(target=job1)
	    t2 = threading.Thread(target=job2)
	    t1.start()
	    t2.start()
	    t1.join()
	    t2.join()
