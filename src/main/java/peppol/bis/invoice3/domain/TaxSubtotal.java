/**
 * Copyright (C) Posten Norge AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package peppol.bis.invoice3.domain;

import org.eaxy.Element;
import org.eaxy.Node;
import org.eaxy.QualifiedName;
import org.eaxy.Xml;

import static peppol.bis.invoice3.domain.Namespaces.CAC_NS;

public class TaxSubtotal implements XmlElement {
    private final TaxableAmount taxableAmount;
    private final TaxAmount taxAmount;
    private final TaxCategory taxCategory;

    public TaxSubtotal(TaxableAmount taxableAmount, TaxAmount taxAmount, TaxCategory taxCategory) {
        this.taxableAmount = taxableAmount;
        this.taxAmount = taxAmount;
        this.taxCategory = taxCategory;
    }

    @Override
    public Node node() {
        final Element elm = Xml.el(new QualifiedName(CAC_NS, name()));

        required(this.taxableAmount, elm);
        required(this.taxAmount, elm);
        required(this.taxCategory, elm);

        return elm;
    }
}
