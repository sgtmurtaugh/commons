package de.ckraus.commons.pdf;

/**
 * <p>All modify Methods <strong>must</strong> return three different modification states for consistent handling:
 * <ul>
 *     <li>true - succeeded</li>
 *     <li>false - failed</li>
 *     <li>null - omitted</li>
 * </ul>
 */
public interface IPdfDocumentModifier
    extends IPdfModifer {

}
