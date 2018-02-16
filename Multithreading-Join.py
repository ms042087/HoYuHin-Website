# -*- coding: utf-8 -*-
"""
Created on Sun Feb 18 12:15:48 2018

@author: Ho Yu Hin
"""

import threading
from multiprocessing import Queue

def job(l,q):
    for i in range(len(l)):
        l[i]=l[i]**2
    q.put(l)

def multiThreading(data):
    q = Queue()
    threads = []
    
    for i in range(len(data)):
        t = threading.Thread(target=job, args=(data[i],q))
        t.start()
        threads.append(t)
        
    for thread in threads:
        thread.join()  
        
    results=[]
    for _ in range(len(data)):
        results.append(q.get())
        
    print(results)
    
    #print(threading.active_count())
    #print(threading.enumerate())
    #print(threading.current_thread())
    
if __name__ == '__main__':
    data=[[1,2,3],[3,4,5],[4,4,4],[5,5,5]]
    multiThreading(data)