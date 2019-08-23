Python 3.5.2  
[Link](https://www.python.org/downloads/release/python-352/)

Install TF GPU version  

    pip3 install --upgrade tensorflow-gpu

CUDA Toolkit 9.0 Downloads  
[Link](https://developer.nvidia.com/cuda-90-download-archive?target_os=Windows&target_arch=x86_64&target_version=10&target_type=exenetwork)

Download cuDNN v7.0.5 (Dec 5, 2017), for CUDA 9.0  
[Link](https://developer.nvidia.com/rdp/cudnn-download)

Run the following code to test

    import tensorflow as tf
    hello = tf.constant('Hello, TensorFlow!')
    sess = tf.Session()
    print(sess.run(hello))