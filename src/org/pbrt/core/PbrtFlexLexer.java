/* The following code was generated by JFlex 1.4.3 on 2/11/17 9:30 PM */

package org.pbrt.core;

import com.intellij.lexer.*;
import org.pbrt.core.PbrtParser.Lexer;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/11/17 9:30 PM from the specification file
 * <tt>PbrtScene.flex</tt>
 */
class PbrtFlexLexer implements FlexLexer, java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\11\1\6\2\0\1\11\22\0\1\11\1\0\1\7\1\5"+
    "\7\0\1\3\1\0\1\3\1\4\1\0\12\2\7\0\1\12\1\37"+
    "\1\42\1\1\1\40\1\44\2\1\1\45\2\1\1\31\1\47\1\50"+
    "\1\51\1\53\1\1\1\55\1\34\1\24\2\1\1\57\3\1\1\60"+
    "\1\10\1\61\1\0\1\1\1\0\1\17\1\36\1\13\1\41\1\14"+
    "\1\27\1\32\1\33\1\22\1\52\1\46\1\15\1\30\1\25\1\21"+
    "\1\56\1\1\1\16\1\26\1\20\1\35\1\23\1\1\1\54\1\43"+
    "\1\1\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\3\2\4\1\5"+
    "\16\2\1\6\1\7\1\0\2\5\34\2\1\10\53\2"+
    "\1\11\24\2\1\12\2\2\1\13\27\2\1\14\4\2"+
    "\1\15\15\2\1\16\6\2\1\17\3\2\1\20\1\2"+
    "\1\21\3\2\1\22\31\2\1\23\1\2\1\24\10\2"+
    "\1\25\4\2\1\26\1\27\1\2\1\30\10\2\1\31"+
    "\20\2\1\32\7\2\1\33\1\34\7\2\1\35\7\2"+
    "\1\36\1\2\1\37\4\2\1\40\2\2\1\41\24\2"+
    "\1\42\4\2\1\43\1\44\1\45\6\2\1\46\1\2"+
    "\1\47\1\50\2\2\1\51\1\52\1\53\2\2\1\54"+
    "\3\2\1\55\1\56\1\2\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[344];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee"+
    "\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\62"+
    "\0\62\0\310\0\62\0\u047e\0\u04b0\0\u04e2\0\u0514\0\u0546"+
    "\0\u0578\0\u05aa\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6"+
    "\0\u0708\0\u073a\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866"+
    "\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6"+
    "\0\144\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54"+
    "\0\u0b86\0\u0bb8\0\u0bea\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2\0\u0ce4"+
    "\0\u0d16\0\u0d48\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\u0e74"+
    "\0\u0ea6\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004"+
    "\0\u1036\0\u1068\0\u109a\0\u10cc\0\u10fe\0\u1130\0\u1162\0\u1194"+
    "\0\u11c6\0\u11f8\0\u122a\0\u125c\0\144\0\u128e\0\u12c0\0\u12f2"+
    "\0\u1324\0\u1356\0\u1388\0\u13ba\0\u13ec\0\u141e\0\u1450\0\u1482"+
    "\0\u14b4\0\u14e6\0\u1518\0\u154a\0\u157c\0\u15ae\0\u15e0\0\u1612"+
    "\0\u1644\0\144\0\u1676\0\u16a8\0\144\0\u16da\0\u170c\0\u173e"+
    "\0\u1770\0\u17a2\0\u17d4\0\u1806\0\u1838\0\u186a\0\u189c\0\u18ce"+
    "\0\u1900\0\u1932\0\u1964\0\u1996\0\u19c8\0\u19fa\0\u1a2c\0\u1a5e"+
    "\0\u1a90\0\u1ac2\0\u1af4\0\u1b26\0\144\0\u1b58\0\u1b8a\0\u1bbc"+
    "\0\u1bee\0\144\0\u1c20\0\u1c52\0\u1c84\0\u1cb6\0\u1ce8\0\u1d1a"+
    "\0\u1d4c\0\u1d7e\0\u1db0\0\u1de2\0\u1e14\0\u1e46\0\u1e78\0\144"+
    "\0\u1eaa\0\u1edc\0\u1f0e\0\u1f40\0\u1f72\0\u1fa4\0\144\0\u1fd6"+
    "\0\u2008\0\u203a\0\144\0\u206c\0\144\0\u209e\0\u20d0\0\u2102"+
    "\0\144\0\u2134\0\u2166\0\u2198\0\u21ca\0\u21fc\0\u222e\0\u2260"+
    "\0\u2292\0\u22c4\0\u22f6\0\u2328\0\u235a\0\u238c\0\u23be\0\u23f0"+
    "\0\u2422\0\u2454\0\u2486\0\u24b8\0\u24ea\0\u251c\0\u254e\0\u2580"+
    "\0\u25b2\0\u25e4\0\144\0\u2616\0\144\0\u2648\0\u267a\0\u26ac"+
    "\0\u26de\0\u2710\0\u2742\0\u2774\0\u27a6\0\144\0\u27d8\0\u280a"+
    "\0\u283c\0\u286e\0\144\0\u28a0\0\u28d2\0\144\0\u2904\0\u2936"+
    "\0\u2968\0\u299a\0\u29cc\0\u29fe\0\u2a30\0\u2a62\0\144\0\u2a94"+
    "\0\u2ac6\0\u2af8\0\u2b2a\0\u2b5c\0\u2b8e\0\u2bc0\0\u2bf2\0\u2c24"+
    "\0\u2c56\0\u2c88\0\u2cba\0\u2cec\0\u2d1e\0\u2d50\0\u2d82\0\144"+
    "\0\u2db4\0\u2de6\0\u2e18\0\u2e4a\0\u2e7c\0\u2eae\0\u2ee0\0\144"+
    "\0\144\0\u2f12\0\u2f44\0\u2f76\0\u2fa8\0\u2fda\0\u300c\0\u303e"+
    "\0\144\0\u3070\0\u30a2\0\u30d4\0\u3106\0\u3138\0\u316a\0\u319c"+
    "\0\144\0\u31ce\0\144\0\u3200\0\u3232\0\u3264\0\u3296\0\144"+
    "\0\u32c8\0\u32fa\0\144\0\u332c\0\u335e\0\u3390\0\u33c2\0\u33f4"+
    "\0\u3426\0\u3458\0\u348a\0\u34bc\0\u34ee\0\u3520\0\u3552\0\u3584"+
    "\0\u35b6\0\u35e8\0\u361a\0\u364c\0\u367e\0\u36b0\0\u36e2\0\144"+
    "\0\u3714\0\u3746\0\u3778\0\u37aa\0\144\0\144\0\144\0\u37dc"+
    "\0\u380e\0\u3840\0\u3872\0\u38a4\0\u38d6\0\144\0\u3908\0\144"+
    "\0\144\0\u393a\0\u396c\0\144\0\144\0\144\0\u399e\0\u39d0"+
    "\0\144\0\u3a02\0\u3a34\0\u3a66\0\144\0\144\0\u3a98\0\144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[344];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\2\1\10\1\12\11\3\1\13\4\3\1\14\2\3"+
    "\1\15\3\3\1\16\1\3\1\17\1\3\1\20\1\21"+
    "\1\3\1\22\1\23\1\24\1\3\1\25\1\3\1\26"+
    "\1\3\1\27\1\30\1\31\63\0\2\3\7\0\46\3"+
    "\4\0\1\4\1\0\1\6\57\0\1\4\1\32\1\6"+
    "\57\0\1\6\57\0\6\7\1\0\53\7\6\0\1\10"+
    "\2\0\1\10\50\0\7\11\1\33\1\34\51\11\1\0"+
    "\2\3\7\0\1\3\1\35\1\3\1\36\1\37\1\3"+
    "\1\40\37\3\3\0\2\3\7\0\2\3\1\41\1\3"+
    "\1\42\41\3\3\0\2\3\7\0\7\3\1\43\1\44"+
    "\35\3\3\0\2\3\7\0\1\3\1\45\3\3\1\46"+
    "\1\47\12\3\1\50\24\3\3\0\2\3\7\0\13\3"+
    "\1\51\32\3\3\0\2\3\7\0\5\3\1\52\1\3"+
    "\1\53\36\3\3\0\2\3\7\0\10\3\1\54\35\3"+
    "\3\0\2\3\7\0\13\3\1\55\13\3\1\56\16\3"+
    "\3\0\2\3\7\0\2\3\1\57\2\3\1\60\40\3"+
    "\3\0\2\3\7\0\5\3\1\61\40\3\3\0\2\3"+
    "\7\0\24\3\1\62\21\3\3\0\2\3\7\0\10\3"+
    "\1\63\35\3\3\0\2\3\7\0\2\3\1\64\4\3"+
    "\1\65\36\3\3\0\2\3\7\0\7\3\1\66\36\3"+
    "\2\0\62\11\1\0\2\3\7\0\1\3\1\67\4\3"+
    "\1\70\37\3\3\0\2\3\7\0\3\3\1\71\42\3"+
    "\3\0\2\3\7\0\2\3\1\72\43\3\3\0\2\3"+
    "\7\0\6\3\1\73\37\3\3\0\2\3\7\0\42\3"+
    "\1\74\3\3\3\0\2\3\7\0\5\3\1\75\40\3"+
    "\3\0\2\3\7\0\7\3\1\76\36\3\3\0\2\3"+
    "\7\0\20\3\1\77\25\3\3\0\2\3\7\0\5\3"+
    "\1\100\40\3\3\0\2\3\7\0\16\3\1\101\27\3"+
    "\3\0\2\3\7\0\5\3\1\102\40\3\3\0\2\3"+
    "\7\0\5\3\1\103\40\3\3\0\2\3\7\0\27\3"+
    "\1\104\16\3\3\0\2\3\7\0\16\3\1\105\27\3"+
    "\3\0\2\3\7\0\7\3\1\106\3\3\1\107\32\3"+
    "\3\0\2\3\7\0\3\3\1\110\42\3\3\0\2\3"+
    "\7\0\1\3\1\111\4\3\1\112\37\3\3\0\2\3"+
    "\7\0\2\3\1\113\43\3\3\0\2\3\7\0\27\3"+
    "\1\114\16\3\3\0\2\3\7\0\6\3\1\115\25\3"+
    "\1\116\11\3\3\0\2\3\7\0\16\3\1\117\27\3"+
    "\3\0\2\3\7\0\40\3\1\120\5\3\3\0\2\3"+
    "\7\0\42\3\1\121\3\3\3\0\2\3\7\0\11\3"+
    "\1\122\34\3\3\0\2\3\7\0\6\3\1\123\37\3"+
    "\3\0\2\3\7\0\4\3\1\124\41\3\3\0\2\3"+
    "\7\0\2\3\1\125\43\3\3\0\2\3\7\0\10\3"+
    "\1\126\35\3\3\0\2\3\7\0\5\3\1\127\40\3"+
    "\3\0\2\3\7\0\4\3\1\130\41\3\3\0\2\3"+
    "\7\0\6\3\1\131\37\3\3\0\2\3\7\0\13\3"+
    "\1\132\32\3\3\0\2\3\7\0\34\3\1\133\11\3"+
    "\3\0\2\3\7\0\21\3\1\134\24\3\3\0\2\3"+
    "\7\0\3\3\1\135\42\3\3\0\2\3\7\0\44\3"+
    "\1\136\1\3\3\0\2\3\7\0\4\3\1\137\41\3"+
    "\3\0\2\3\7\0\44\3\1\140\1\3\3\0\2\3"+
    "\7\0\12\3\1\141\33\3\3\0\2\3\7\0\2\3"+
    "\1\142\43\3\3\0\2\3\7\0\4\3\1\143\41\3"+
    "\3\0\2\3\7\0\1\3\1\144\44\3\3\0\2\3"+
    "\7\0\16\3\1\145\27\3\3\0\2\3\7\0\3\3"+
    "\1\146\42\3\3\0\2\3\7\0\2\3\1\147\43\3"+
    "\3\0\2\3\7\0\13\3\1\150\32\3\3\0\2\3"+
    "\7\0\10\3\1\151\35\3\3\0\2\3\7\0\2\3"+
    "\1\152\43\3\3\0\2\3\7\0\2\3\1\153\43\3"+
    "\3\0\2\3\7\0\2\3\1\154\43\3\3\0\2\3"+
    "\7\0\2\3\1\155\43\3\3\0\2\3\7\0\2\3"+
    "\1\156\43\3\3\0\2\3\7\0\2\3\1\157\43\3"+
    "\3\0\2\3\7\0\5\3\1\160\40\3\3\0\2\3"+
    "\7\0\3\3\1\161\42\3\3\0\2\3\7\0\3\3"+
    "\1\162\42\3\3\0\2\3\7\0\11\3\1\163\34\3"+
    "\3\0\2\3\7\0\17\3\1\164\26\3\3\0\2\3"+
    "\7\0\10\3\1\165\35\3\3\0\2\3\7\0\23\3"+
    "\1\166\22\3\3\0\2\3\7\0\14\3\1\167\31\3"+
    "\3\0\2\3\7\0\1\170\45\3\3\0\2\3\7\0"+
    "\6\3\1\171\37\3\3\0\2\3\7\0\2\3\1\172"+
    "\43\3\3\0\2\3\7\0\3\3\1\173\42\3\3\0"+
    "\2\3\7\0\6\3\1\174\37\3\3\0\2\3\7\0"+
    "\2\3\1\175\43\3\3\0\2\3\7\0\10\3\1\176"+
    "\35\3\3\0\2\3\7\0\4\3\1\177\41\3\3\0"+
    "\2\3\7\0\27\3\1\200\16\3\3\0\2\3\7\0"+
    "\5\3\1\201\40\3\3\0\2\3\7\0\23\3\1\202"+
    "\22\3\3\0\2\3\7\0\20\3\1\203\25\3\3\0"+
    "\2\3\7\0\6\3\1\204\37\3\3\0\2\3\7\0"+
    "\23\3\1\205\22\3\3\0\2\3\7\0\4\3\1\206"+
    "\41\3\3\0\2\3\7\0\36\3\1\207\7\3\3\0"+
    "\2\3\7\0\27\3\1\210\16\3\3\0\2\3\7\0"+
    "\1\3\1\211\44\3\3\0\2\3\7\0\3\3\1\212"+
    "\42\3\3\0\2\3\7\0\4\3\1\213\41\3\3\0"+
    "\2\3\7\0\6\3\1\214\37\3\3\0\2\3\7\0"+
    "\27\3\1\215\16\3\3\0\2\3\7\0\2\3\1\216"+
    "\43\3\3\0\2\3\7\0\2\3\1\217\43\3\3\0"+
    "\2\3\7\0\10\3\1\220\35\3\3\0\2\3\7\0"+
    "\24\3\1\221\21\3\3\0\2\3\7\0\4\3\1\222"+
    "\41\3\3\0\2\3\7\0\3\3\1\223\11\3\1\224"+
    "\30\3\3\0\2\3\7\0\6\3\1\225\37\3\3\0"+
    "\2\3\7\0\22\3\1\226\23\3\3\0\2\3\7\0"+
    "\2\3\1\227\43\3\3\0\2\3\7\0\12\3\1\230"+
    "\33\3\3\0\2\3\7\0\16\3\1\231\27\3\3\0"+
    "\2\3\7\0\5\3\1\232\40\3\3\0\2\3\7\0"+
    "\10\3\1\233\11\3\1\234\23\3\3\0\2\3\7\0"+
    "\6\3\1\235\37\3\3\0\2\3\7\0\27\3\1\236"+
    "\16\3\3\0\2\3\7\0\4\3\1\237\41\3\3\0"+
    "\2\3\7\0\10\3\1\240\35\3\3\0\2\3\7\0"+
    "\16\3\1\241\27\3\3\0\2\3\7\0\10\3\1\242"+
    "\35\3\3\0\2\3\7\0\5\3\1\243\40\3\3\0"+
    "\2\3\7\0\35\3\1\244\10\3\3\0\2\3\7\0"+
    "\6\3\1\245\37\3\3\0\2\3\7\0\32\3\1\246"+
    "\13\3\3\0\2\3\7\0\14\3\1\247\31\3\3\0"+
    "\2\3\7\0\2\3\1\250\43\3\3\0\2\3\7\0"+
    "\25\3\1\251\1\252\17\3\3\0\2\3\7\0\4\3"+
    "\1\253\41\3\3\0\2\3\7\0\12\3\1\254\33\3"+
    "\3\0\2\3\7\0\20\3\1\255\25\3\3\0\2\3"+
    "\7\0\23\3\1\256\22\3\3\0\2\3\7\0\2\3"+
    "\1\257\43\3\3\0\2\3\7\0\5\3\1\260\40\3"+
    "\3\0\2\3\7\0\7\3\1\261\36\3\3\0\2\3"+
    "\7\0\7\3\1\262\36\3\3\0\2\3\7\0\4\3"+
    "\1\263\41\3\3\0\2\3\7\0\10\3\1\264\35\3"+
    "\3\0\2\3\7\0\2\3\1\265\43\3\3\0\2\3"+
    "\7\0\13\3\1\266\32\3\3\0\2\3\7\0\31\3"+
    "\1\267\14\3\3\0\2\3\7\0\12\3\1\270\33\3"+
    "\3\0\2\3\7\0\2\3\1\271\43\3\3\0\2\3"+
    "\7\0\5\3\1\272\40\3\3\0\2\3\7\0\6\3"+
    "\1\273\37\3\3\0\2\3\7\0\33\3\1\274\12\3"+
    "\3\0\2\3\7\0\5\3\1\275\40\3\3\0\2\3"+
    "\7\0\16\3\1\276\27\3\3\0\2\3\7\0\5\3"+
    "\1\277\40\3\3\0\2\3\7\0\25\3\1\300\1\301"+
    "\4\3\1\302\12\3\3\0\2\3\7\0\10\3\1\303"+
    "\35\3\3\0\2\3\7\0\2\3\1\304\43\3\3\0"+
    "\2\3\7\0\2\3\1\305\43\3\3\0\2\3\7\0"+
    "\13\3\1\306\32\3\3\0\2\3\7\0\5\3\1\307"+
    "\40\3\3\0\2\3\7\0\4\3\1\310\41\3\3\0"+
    "\2\3\7\0\21\3\1\311\24\3\3\0\2\3\7\0"+
    "\6\3\1\312\37\3\3\0\2\3\7\0\6\3\1\313"+
    "\37\3\3\0\2\3\7\0\4\3\1\314\41\3\3\0"+
    "\2\3\7\0\23\3\1\315\22\3\3\0\2\3\7\0"+
    "\16\3\1\316\27\3\3\0\2\3\7\0\5\3\1\317"+
    "\40\3\3\0\2\3\7\0\14\3\1\320\31\3\3\0"+
    "\2\3\7\0\4\3\1\321\41\3\3\0\2\3\7\0"+
    "\6\3\1\322\37\3\3\0\2\3\7\0\31\3\1\323"+
    "\14\3\3\0\2\3\7\0\13\3\1\324\32\3\3\0"+
    "\2\3\7\0\3\3\1\325\42\3\3\0\2\3\7\0"+
    "\2\3\1\326\43\3\3\0\2\3\7\0\6\3\1\327"+
    "\37\3\3\0\2\3\7\0\2\3\1\330\43\3\3\0"+
    "\2\3\7\0\13\3\1\331\32\3\3\0\2\3\7\0"+
    "\13\3\1\332\32\3\3\0\2\3\7\0\3\3\1\333"+
    "\42\3\3\0\2\3\7\0\37\3\1\334\6\3\3\0"+
    "\2\3\7\0\20\3\1\335\25\3\3\0\2\3\7\0"+
    "\27\3\1\336\16\3\3\0\2\3\7\0\6\3\1\337"+
    "\37\3\3\0\2\3\7\0\5\3\1\340\40\3\3\0"+
    "\2\3\7\0\6\3\1\341\37\3\3\0\2\3\7\0"+
    "\2\3\1\342\43\3\3\0\2\3\7\0\2\3\1\343"+
    "\43\3\3\0\2\3\7\0\16\3\1\344\27\3\3\0"+
    "\2\3\7\0\4\3\1\345\41\3\3\0\2\3\7\0"+
    "\2\3\1\346\43\3\3\0\2\3\7\0\6\3\1\347"+
    "\37\3\3\0\2\3\7\0\12\3\1\350\33\3\3\0"+
    "\2\3\7\0\5\3\1\351\40\3\3\0\2\3\7\0"+
    "\7\3\1\352\36\3\3\0\2\3\7\0\6\3\1\353"+
    "\37\3\3\0\2\3\7\0\27\3\1\354\16\3\3\0"+
    "\2\3\7\0\2\3\1\355\43\3\3\0\2\3\7\0"+
    "\20\3\1\356\25\3\3\0\2\3\7\0\27\3\1\357"+
    "\16\3\3\0\2\3\7\0\14\3\1\360\31\3\3\0"+
    "\2\3\7\0\6\3\1\361\37\3\3\0\2\3\7\0"+
    "\4\3\1\362\41\3\3\0\2\3\7\0\10\3\1\363"+
    "\35\3\3\0\2\3\7\0\7\3\1\364\36\3\3\0"+
    "\2\3\7\0\13\3\1\365\32\3\3\0\2\3\7\0"+
    "\22\3\1\366\23\3\3\0\2\3\7\0\25\3\1\367"+
    "\1\370\17\3\3\0\2\3\7\0\12\3\1\371\12\3"+
    "\1\372\1\373\17\3\3\0\2\3\7\0\1\3\1\374"+
    "\44\3\3\0\2\3\7\0\2\3\1\375\43\3\3\0"+
    "\2\3\7\0\4\3\1\376\41\3\3\0\2\3\7\0"+
    "\13\3\1\377\32\3\3\0\2\3\7\0\4\3\1\u0100"+
    "\41\3\3\0\2\3\7\0\2\3\1\u0101\43\3\3\0"+
    "\2\3\7\0\35\3\1\u0102\10\3\3\0\2\3\7\0"+
    "\4\3\1\u0103\41\3\3\0\2\3\7\0\10\3\1\u0104"+
    "\35\3\3\0\2\3\7\0\6\3\1\u0105\37\3\3\0"+
    "\2\3\7\0\2\3\1\u0106\43\3\3\0\2\3\7\0"+
    "\10\3\1\u0107\35\3\3\0\2\3\7\0\13\3\1\u0108"+
    "\32\3\3\0\2\3\7\0\4\3\1\u0109\41\3\3\0"+
    "\2\3\7\0\14\3\1\u010a\31\3\3\0\2\3\7\0"+
    "\7\3\1\u010b\36\3\3\0\2\3\7\0\2\3\1\u010c"+
    "\43\3\3\0\2\3\7\0\13\3\1\u010d\32\3\3\0"+
    "\2\3\7\0\10\3\1\u010e\35\3\3\0\2\3\7\0"+
    "\2\3\1\u010f\43\3\3\0\2\3\7\0\13\3\1\u0110"+
    "\32\3\3\0\2\3\7\0\2\3\1\u0111\43\3\3\0"+
    "\2\3\7\0\22\3\1\u0112\23\3\3\0\2\3\7\0"+
    "\5\3\1\u0113\40\3\3\0\2\3\7\0\14\3\1\u0114"+
    "\31\3\3\0\2\3\7\0\4\3\1\u0115\41\3\3\0"+
    "\2\3\7\0\2\3\1\u0116\2\3\1\u0117\40\3\3\0"+
    "\2\3\7\0\10\3\1\u0118\35\3\3\0\2\3\7\0"+
    "\13\3\1\u0119\32\3\3\0\2\3\7\0\5\3\1\u011a"+
    "\40\3\3\0\2\3\7\0\4\3\1\u011b\41\3\3\0"+
    "\2\3\7\0\2\3\1\u011c\43\3\3\0\2\3\7\0"+
    "\15\3\1\u011d\30\3\3\0\2\3\7\0\23\3\1\u011e"+
    "\22\3\3\0\2\3\7\0\20\3\1\u011f\25\3\3\0"+
    "\2\3\7\0\27\3\1\u0120\16\3\3\0\2\3\7\0"+
    "\16\3\1\u0121\27\3\3\0\2\3\7\0\20\3\1\u0122"+
    "\25\3\3\0\2\3\7\0\27\3\1\u0123\16\3\3\0"+
    "\2\3\7\0\31\3\1\u0124\14\3\3\0\2\3\7\0"+
    "\13\3\1\u0125\32\3\3\0\2\3\7\0\15\3\1\u0126"+
    "\30\3\3\0\2\3\7\0\15\3\1\u0127\30\3\3\0"+
    "\2\3\7\0\27\3\1\u0128\16\3\3\0\2\3\7\0"+
    "\6\3\1\u0129\37\3\3\0\2\3\7\0\5\3\1\u012a"+
    "\40\3\3\0\2\3\7\0\13\3\1\u012b\32\3\3\0"+
    "\2\3\7\0\13\3\1\u012c\32\3\3\0\2\3\7\0"+
    "\7\3\1\u012d\36\3\3\0\2\3\7\0\4\3\1\u012e"+
    "\41\3\3\0\2\3\7\0\10\3\1\u012f\35\3\3\0"+
    "\2\3\7\0\2\3\1\u0130\43\3\3\0\2\3\7\0"+
    "\10\3\1\u0131\35\3\3\0\2\3\7\0\14\3\1\u0132"+
    "\31\3\3\0\2\3\7\0\14\3\1\u0133\31\3\3\0"+
    "\2\3\7\0\7\3\1\u0134\36\3\3\0\2\3\7\0"+
    "\5\3\1\u0135\40\3\3\0\2\3\7\0\10\3\1\u0136"+
    "\35\3\3\0\2\3\7\0\2\3\1\u0137\43\3\3\0"+
    "\2\3\7\0\3\3\1\u0138\42\3\3\0\2\3\7\0"+
    "\1\3\1\u0139\44\3\3\0\2\3\7\0\6\3\1\u013a"+
    "\37\3\3\0\2\3\7\0\4\3\1\u013b\41\3\3\0"+
    "\2\3\7\0\1\3\1\u013c\44\3\3\0\2\3\7\0"+
    "\13\3\1\u013d\32\3\3\0\2\3\7\0\14\3\1\u013e"+
    "\31\3\3\0\2\3\7\0\13\3\1\u013f\32\3\3\0"+
    "\2\3\7\0\6\3\1\u0140\37\3\3\0\2\3\7\0"+
    "\15\3\1\u0141\30\3\3\0\2\3\7\0\4\3\1\u0142"+
    "\41\3\3\0\2\3\7\0\1\3\1\u0143\44\3\3\0"+
    "\2\3\7\0\23\3\1\u0144\22\3\3\0\2\3\7\0"+
    "\4\3\1\u0145\41\3\3\0\2\3\7\0\2\3\1\u0146"+
    "\43\3\3\0\2\3\7\0\5\3\1\u0147\40\3\3\0"+
    "\2\3\7\0\16\3\1\u0148\27\3\3\0\2\3\7\0"+
    "\2\3\1\u0149\43\3\3\0\2\3\7\0\2\3\1\u014a"+
    "\43\3\3\0\2\3\7\0\7\3\1\u014b\36\3\3\0"+
    "\2\3\7\0\16\3\1\u014c\27\3\3\0\2\3\7\0"+
    "\2\3\1\u014d\43\3\3\0\2\3\7\0\16\3\1\u014e"+
    "\27\3\3\0\2\3\7\0\10\3\1\u014f\35\3\3\0"+
    "\2\3\7\0\6\3\1\u0150\37\3\3\0\2\3\7\0"+
    "\16\3\1\u0151\27\3\3\0\2\3\7\0\4\3\1\u0152"+
    "\41\3\3\0\2\3\7\0\5\3\1\u0153\40\3\3\0"+
    "\2\3\7\0\10\3\1\u0154\35\3\3\0\2\3\7\0"+
    "\16\3\1\u0155\27\3\3\0\2\3\7\0\3\3\1\u0156"+
    "\42\3\3\0\2\3\7\0\7\3\1\u0157\36\3\3\0"+
    "\2\3\7\0\13\3\1\u0158\32\3\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[15050];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\25\1\2\11\1\0\1\11\u013d\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[344];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  PbrtFlexLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  PbrtFlexLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 144) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Integer advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 41: 
          { return Lexer.CONCATTRANSFORM;
          }
        case 48: break;
        case 40: 
          { return Lexer.AREALIGHTSOURCE;
          }
        case 49: break;
        case 31: 
          { return Lexer.PIXELFILTER;
          }
        case 50: break;
        case 39: 
          { return Lexer.ACTIVETRANSFORM;
          }
        case 51: break;
        case 20: 
          { return Lexer.MATERIAL;
          }
        case 52: break;
        case 33: 
          { return Lexer.TRANSFORMEND;
          }
        case 53: break;
        case 5: 
          { return Lexer.STRING;
          }
        case 54: break;
        case 46: 
          { return Lexer.MAKENAMEDMATERIAL;
          }
        case 55: break;
        case 36: 
          { return Lexer.TRANSFORMTIMES;
          }
        case 56: break;
        case 16: 
          { return Lexer.SAMPLER;
          }
        case 57: break;
        case 19: 
          { return Lexer.IDENTITY;
          }
        case 58: break;
        case 1: 
          { Error.Error("Illegal character: %c (0x%x)", yytext[0], (int)yytext[0]));
          }
        case 59: break;
        case 8: 
          { return Lexer.ALL;
          }
        case 60: break;
        case 15: 
          { return Lexer.TEXTURE;
          }
        case 61: break;
        case 28: 
          { return Lexer.ACCELERATOR;
          }
        case 62: break;
        case 2: 
          { return Lexer.IDENTIFIER;
          }
        case 63: break;
        case 21: 
          { return Lexer.WORLDEND;
          }
        case 64: break;
        case 9: 
          { return Lexer.FILM;
          }
        case 65: break;
        case 10: 
          { return Lexer.SCALE;
          }
        case 66: break;
        case 12: 
          { return Lexer.LOOKAT;
          }
        case 67: break;
        case 22: 
          { return Lexer.TRANSLATE;
          }
        case 68: break;
        case 34: 
          { return Lexer.NAMEDMATERIAL;
          }
        case 69: break;
        case 23: 
          { return Lexer.TRANSFORM;
          }
        case 70: break;
        case 38: 
          { return Lexer.OBJECTINSTANCE;
          }
        case 71: break;
        case 29: 
          { return Lexer.LIGHTSOURCE;
          }
        case 72: break;
        case 26: 
          { return Lexer.INTEGRATOR;
          }
        case 73: break;
        case 25: 
          { return Lexer.OBJECTEND;
          }
        case 74: break;
        case 6: 
          { return Lexer.LBRACK;
          }
        case 75: break;
        case 18: 
          { return Lexer.INCLUDE;
          }
        case 76: break;
        case 47: 
          { return Lexer.REVERSEORIENTATION;
          }
        case 77: break;
        case 42: 
          { return Lexer.MEDIUMINTERFACE;
          }
        case 78: break;
        case 24: 
          { return Lexer.STARTTIME;
          }
        case 79: break;
        case 13: 
          { return Lexer.CAMERA;
          }
        case 80: break;
        case 7: 
          { return Lexer.RBRACK;
          }
        case 81: break;
        case 30: 
          { return Lexer.OBJECTBEGIN;
          }
        case 82: break;
        case 43: 
          { return Lexer.MAKENAMEDMEDIUM;
          }
        case 83: break;
        case 17: 
          { return Lexer.ENDTIME;
          }
        case 84: break;
        case 3: 
          { return Lexer.NUMBER;
          }
        case 85: break;
        case 11: 
          { return Lexer.SHAPE;
          }
        case 86: break;
        case 35: 
          { return Lexer.ATTRIBUTEBEGIN;
          }
        case 87: break;
        case 45: 
          { return Lexer.COORDSYSTRANSFORM;
          }
        case 88: break;
        case 32: 
          { return Lexer.ATTRIBUTEEND;
          }
        case 89: break;
        case 14: 
          { return Lexer.ROTATE;
          }
        case 90: break;
        case 44: 
          { return Lexer.COORDINATESYSTEM;
          }
        case 91: break;
        case 37: 
          { return Lexer.TRANSFORMBEGIN;
          }
        case 92: break;
        case 27: 
          { return Lexer.WORLDBEGIN;
          }
        case 93: break;
        case 4: 
          { 
          }
        case 94: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}