import numpy as np
import gzip
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report, roc_auc_score
from sklearn.neural_network import MLPClassifier

testLoc={
    'image':'MNIST_DATA/t10k-images-idx3-ubyte.gz',
    'label': 'MNIST_DATA/t10k-labels-idx1-ubyte.gz'
}
trainLoc={
    'image':'MNIST_DATA/train-images-idx3-ubyte.gz',
    'label': 'MNIST_DATA/train-labels-idx1-ubyte.gz'
}

def extract_Images(filename):
    f=gzip.open(filename,'r')
    f.read(4) #magic number
    nImgs= int.from_bytes(f.read(4),'big')    
    row= int.from_bytes(f.read(4),'big')    
    col= int.from_bytes(f.read(4),'big')    
    data=f.read()
    images= np.frombuffer(data,dtype=np.uint8).astype(np.float32).reshape((nImgs,row,col))
    return images

def extract_Labels(filename):
    file = gzip.open(filename,'rb')
    file.read(8)
    data= file.read()
    labs = np.frombuffer(data,dtype=np.uint8).astype(np.int32)
    return labs

trainImg = extract_Images(trainLoc['image'])
trainLab = extract_Labels(trainLoc['label'])

testImg = extract_Images(testLoc['image'])
testLab = extract_Labels(testLoc['label'])

print(trainImg.shape)
print(testImg.shape)
print(trainLab.shape)
print(testLab.shape)

#TRAIN function
def train(images, labels, classifier):
    images = images.reshape(images.shape[0],-1)
    classifier.fit(images,labels)

    print("Training Done..")
    
    ''' Training set Performance (but costly ops) '''
    # output = classifier.predict(images)
    # train_acc = (output==labels).sum()/labels.shape[0]
    # print("Training Accuracy: ", train_acc)

#TEST function
def test(images,labels,classifier):
    images = images.reshape(images.shape[0],-1)
    op = classifier.predict(images)
    # train(trainImg,trainLab,NN)

    test_acc = (op==labels).sum()/labels.shape[0]
    print("Test set Accuracy: {:.3f}%".format(test_acc*100))
    clReport= classification_report(labels,op, digits=3)
    print(clReport)
    auc = roc_auc_score(labels, classifier.predict_proba(images), multi_class="ovr")
    print("ROC AUC Score: ",auc)



KNN = KNeighborsClassifier(n_neighbors=10)

NN = MLPClassifier(random_state=1, solver= 'adam', max_iter=300, hidden_layer_sizes=(256,128,64))

#NN
print("Three layer NN")
train(trainImg,trainLab,NN)
test(testImg,testLab,NN)

#Training Testing in KNN classifier
print("KNN Classifier")
train(trainImg,trainLab,KNN)
test(testImg[:500],testLab[:500],KNN)
