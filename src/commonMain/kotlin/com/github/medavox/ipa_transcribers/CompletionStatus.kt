/*
IPA Transcribers
Copyright (C) 2018 - 2025  Adam Howard

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.medavox.ipa_transcribers

enum class CompletionStatus {

    /**There is no transcriber for this language/orthography.*/
    UNSTARTED,

    /**This transcriber is not complete, and is not currently being worked on.*/
    INCOMPLETE,

    /**This transcriber is not yet complete, and is currently under construction.
     * Some letters may not yet be handled etc.*/
    IN_PROGRESS,

    /**Pronunciation rules for single letters and simple digraphs have been implemented:
     * There is at least one rule for every character in the orthography.
     * However, more complex linguistic rules not directly represented in the orthography are as-yet
     * unimplemented.*/
    SURFACE_LEVEL_COMPLETE,

    /**The transcriber transliterates all information available in the native orthography.
     * However this is not a complete rendering of how the word is pronounced,
     * due to the nature of the orthography (eg Arabic without extended diacritics does not record
     * short vowels).
     * */
    COMPLETE_PARTIAL,
    /**The transcriber is considered complete,
     * and should produce IPA transliterations that are accurate.*/
    COMPLETE

}