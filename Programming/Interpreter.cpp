// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;


void identifyClassNameRuby(){  //Method used to identify classes in Ruby
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("class");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void identifyClassNameJava(){  //Method used to identify classes in Java
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("class");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void identifyClassNamePHP(){  //Method used to identify classes in PHP
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("class");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listMethodsRuby(){  //Method used to list methods in Ruby
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("def");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listMethodsJava(){  //Method used to list methods in Java
        string line;
        int offset;
        size_t pos,pos1,pos2,pos3;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("public");
                        pos1=line.find("private");
                        pos2=line.find("protected");
                        pos3=line.find("(");
                        if(pos!=string::npos || pos1!=string::npos || pos2!=string::npos ){
                                if(pos3!=string::npos){
                                        cout <<line << endl;
                                }
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listMethodsPHP(){  //Method used to list methods in PHP
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("function");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listPropertiesPHP(){  //Method used to list properties in PHP
        string line;
        int offset;
        size_t pos,pos1;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("public");
                        pos1=line.find("$");
                        if(pos!=string::npos){
                                if(pos1!=string::npos){
                                        cout <<line << endl;
                                }
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listPropertiesRuby(){  //Method used to list properties in PHP
        string line;
        int offset;
        size_t pos,pos1;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("@");
                        if(pos!=string::npos){
                                cout <<line << endl;
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

void listPropertiesJava(){  //Method used to list properties in Ruby
        string line;
        int offset;
        size_t pos,pos1,pos2,pos3,pos4,pos5;
        ifstream myfile ("inputFile.txt");
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("String");
                        pos1=line.find("Long");
                        pos2=line.find("boolean");
                        pos3=line.find("float");
                        pos4=line.find("int");
                        pos5=line.find("(");
                        if(pos!=string::npos | pos1!=string::npos | pos2!=string::npos | pos3!=string::npos | pos4!=string::npos){
                               if(pos5!=string::npos){
                                        continue;
                               }else{
                                        cout <<line << endl;
                               }  
                        }                                
                }
                cout<<"\n\n\n";
                myfile.close();
        }
        else cout << "Unable to open file"; 
}

int main () {
        string line;
        int offset;
        size_t pos;
        ifstream myfile ("inputFile.txt");  //Copy the data into inputFile.txt and then run.
        if(myfile.is_open()) {
                while (getline (myfile,line)){
                        pos=line.find("php");
                        if(pos!=string::npos){  
                                cout <<"Lanuguage: PHP" << "\n\n\n";
                                identifyClassNamePHP();
                                listMethodsPHP();
                                listPropertiesPHP();
                                break;
                        }
                        pos=line.find("main");
                        if(pos!=string::npos){
                                cout <<"Lanuguage: Java" << "\n\n\n";
                                identifyClassNameJava();
                                listMethodsJava();
                                listPropertiesJava();
                                break;
                        }
                        pos=line.find("end");
                        if(pos!=string::npos){
                                cout <<"Lanuguage: Ruby" << "\n\n\n";
                                identifyClassNameRuby();
                                listMethodsRuby();
                                listPropertiesRuby();
                                break;
                        }
                                
                }
                myfile.close();
        }
        else cout << "Unable to open file"; 
        return 0;
}
