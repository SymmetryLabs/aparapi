/**
 * Copyright (c) 2016 - 2017 Syncleus, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aparapi.codegen.test;

public class ForBooleanToggle {
    public void run() {
        boolean pass = false;
        for (int i = 0; i > 2 && i < 10; i++) {
            pass = !pass;
        }

    }
}
/**{OpenCL{
 typedef struct This_s{

 int passid;
 }This;
 int get_pass_id(This *this){
 return this->passid;
 }

 __kernel void run(
 int passid
 ){
 This thisStruct;
 This* this=&thisStruct;
 this->passid = passid;
 {
 char pass = 0;
 for (int i = 0; i>2 && i<10; i++){
 pass = (pass==0)?1:0;
 }
 return;
 }
 }
 }OpenCL}**/

/**{OpenCL{
 typedef struct This_s{

 int passid;
 }This;
 int get_pass_id(This *this){
 return this->passid;
 }

 __kernel void run(
 int passid
 ){
 This thisStruct;
 This* this=&thisStruct;
 this->passid = passid;
 {
 char pass = 0;
 for (int i = 0; i>2 && i<10; i++){
 pass = (pass!=0)?0:1;
 }
 return;
 }
 }
 }OpenCL}**/
