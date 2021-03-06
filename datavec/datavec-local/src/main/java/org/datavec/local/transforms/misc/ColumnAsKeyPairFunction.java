/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.local.transforms.misc;

import lombok.AllArgsConstructor;
import org.datavec.api.writable.Writable;
import org.nd4j.linalg.function.Function;
import org.nd4j.linalg.primitives.Pair;

import java.util.List;

/**
 * Very simple function to extract out one writable (by index) and use it as a key in the resulting PairRDD
 * For example, myWritable.mapToPair(new ColumnsAsKeyPairFunction(myKeyColumnIdx))
 *
 * @author Alex Black
 */
@AllArgsConstructor
public class ColumnAsKeyPairFunction implements Function<List<Writable>, Pair<Writable, List<Writable>>> {
    private final int columnIdx;

    @Override
    public Pair<Writable, List<Writable>> apply(List<Writable> writables) {
        return Pair.of(writables.get(columnIdx), writables);
    }
}
