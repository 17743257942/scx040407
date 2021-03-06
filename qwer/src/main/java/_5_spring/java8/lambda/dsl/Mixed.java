/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package _5_spring.java8.lambda.dsl;

import _5_spring.java8.lambda.dsl.model.Order;

public class Mixed {
    public void mixed() {
        Order order =
                MixedBuilder.forCustomer( "BigBank",
                             MixedBuilder.buy(t -> t.quantity( 80 )
                                        .stock( "IBM" )
                                        .on( "NYSE" )
                                        .at( 125.00 )),
                             MixedBuilder.sell(t -> t.quantity( 50 )
                                         .stock( "GOOGLE" )
                                         .on( "NASDAQ" )
                                         .at( 125.00 )) );

    }
}
