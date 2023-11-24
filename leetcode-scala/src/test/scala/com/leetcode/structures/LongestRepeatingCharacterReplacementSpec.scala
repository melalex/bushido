package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.LongestRepeatingCharacterReplacement.characterReplacement

class LongestRepeatingCharacterReplacementSpec extends TestSpec {

  "LongestRepeatingCharacterReplacementSpec" when {
    "s = \"ABAB\", k = 2" should {
      "return 4" in {
        characterReplacement("ABAB", 2) should be(4)
      }
    }

    "s = \"AABABBA\", k = 1" should {
      "return 4" in {
        characterReplacement("AABABBA", 1) should be(4)
      }
    }

    "s = \"AAAA\", k = 2" should {
      "return 4" in {
        characterReplacement("AAAA", 2) should be(4)
      }
    }

    "huge string" should {
      "return 1065" in {
        characterReplacement("HOFOBTBYHGRGWLFCZTVTPVCNTDWKIVLMVMSCTFXCMLYAMPAUHBLAFTSUCBLJRJZBOWFVTBKOKNVCSTFZMPDILRHNXYIVNIYDTVEQPWGBQMHNDTVJBGPCHYCDXATCXSHDTKOFAVASLNVZZHGALSGXFHWECYGBBJKLNUMBTLQPDFVKOUYKPCVVQBBJLUIYOVDWZFDWGQOFSJGFXCCGOJYHLLOTKRRWPTWZIIXKWXAPJAQSHYMKZSGABRMPEWLZNURONELDVZDVYLGBZPPKLFYOJSBEVLMEZFEUQFOVISLWCTCUNLIBSWQJLBSZMHJHJFSVSVPTRUQYTPRTBLCBWTOVWBKLESBFSCRIODQKIBRSDBXETYONBMXQUDBDONRJQQBEERNDJWIWPBXHSTRKJTAAVCXELYTYQUAQJVARTKTGNNJHLPLCQRUACRMKLSCLMUPCAEJZGWACNLEXGQDVYRIZFCWPIBRQJNDPOBYLIAJDLAWZUIOZINPEEISKXUKDDPIHUVMOKRGPOXRMCQQUNXAXDFRUHKVKLJGIQSHUAWYXDFZAZARMZJTHOSIRRNCZKMYPSHFNIADJGPRDVTZVHDSXDEOABZJSNZHHVQFTWJAFVIMEBKVBBGGDWJUCZYHPYTWEXRYJSNKLBNPCHIZGELMGRKVJECLRFNCDGNXPDDIQFMRFSRLZNIIIJPXQESIQWLKDGKQSDJJTHEFQJWQPMYSCHOFFNPRJHZQLWTNCJHVSYMRAIDPNHPWDTVCCMXAKXPNZCJIEMUGWQCVRJOYJICNGYSYBKKZDADXPBHOEHJECEKTJKXMIMUOHRIOBOMHGKRKUQFCCMKFUVDPNOLAOVAMEGMHLPFGCSCOQDUZCKWWMEYIXUNDRRGHSUJFEYKVHHFEIVKOODHGOMJXGRMVTFKZJUFYSJNWSIBBUZZMIWNIDCMARWFKLQGIBOUUYOKOAKGZBBZUXZTDEXVFRXXDVPLVKJIOUUDXVFRHLGUKPJDGOBSXIOWJWOICDIRJISYWOZYINRCMIZDYPQTJXYBRKXJFPIQFXGJSCWXKHYISKPEZOGDQXTWJJTNVMLBHCGPUATVOHNHCSZWSABTNOVAAJSFYTZSDSVNKDTEJOMWEMCASYRXCMNZEZDNQQWVRUFFNWOZEMIPXWMODSPDLXUYBNOXVZZYJTWAFGORAOZOMLHCTKUVHVQFPZSCFEUVTNCPQEPJHXYDKZVSOIXLHXMKHXOJFBPBKFQOSRTXLLJUJBHSIXMZGNKCTJLJVLHNOAHICPSHBGVATTJGBNQVJVAKAPGQWBUHVPVPAJJJJGRYFHZGIDTNNPXWCCFSBBYEBIXTESHYVLXCKICCWWHJMUXJXZYBIEORRQGWFXCTRRXKEOYQEBZGQJRMODERYSZTHZRJDZQTLCDFCYHLIUSXWGKDHBJDFGOALSHIAUDKQDZYDWFPRMCEYZBKMZFURIGRVCKEXGHSQEWLATVUHAPCZNYYUUOSTCATUSKWGMSCCBBYREQPXYPHHZHXWWYARQXNRNYMRKNVMTSXGBTPRUZMWHBZJPVRLLKECEZUGFBVYTWYTJAODDNQEZRFRMDWUWDISMTXANVYSRICNEPHLSQKFVQKYLBKZZZBSKKKVPRMSSTBCVRWFSPEKFPUICKNNTSMRRIGAFJHKBRVAAVWVYVCCDPVAUSBSETLOZVGZBAVZSOYUGYHVRWWKQXQJNCJNEZPJIABYVVEEGOBAZVFAWTCKLTFNQDVCJEPAUDWUPTETTGMWGNDMBGBSSVNBSIIQNWLXFUTWLIZQQJAYYRARIMUZPIMDOQMATXJVAXDXDHLHKMERUMJJFGJGCZVZSJXQASVTJIPURMALABCTQZQWAUNVHUEVBGTGVCLALCBLDUBDIZPFFAZDPRLKJTLSYQDLUZDPOWOIUYLQHVWIIYYHASUKWDXAFBDYUQUXLZYULMYFFLXKZTFHBEFIGUWUUYLJVXKMIQVFGTJKUNGPQHLXEMRHBUUEYVWMSOWZURUSEKZBTLZXTWCXCHUSBYNIVXBXUWTEAAIXXLUZXLRYRDNETDRBYJOAVEYUQKPOTDJZFBTTMJAEGRQTVWTRZPJOVAIGPIEDKRHVRNMEILXFMFODLNIVSMHZWZHEDMANFSMQNBPQCMRXOCWVNZIQCFDNSZJLTBUAVCIKVTQRXWMXWCSNTVPWAGXCRGRBGMMDNCLFRSUJZAYLVJAZITZPFHCCKXERAWKHZOFETVXWCASLWSYISVBSAAIMYNCGHYFACMSUCBBBVFTPHQSSGNMNPFJCMEFOVDXBOZLPCTBFWLYRRWYNWSAPZFZGBHBKFGQBBJOZBGXDYNLPDRPDPMIFDVTXGELHHQLXQPQVPQAETJFEQZQNRZTVJKIWZKLXMZUJSEJOSSYHRHKOQPUEWKMYZVAVPXCLWMCNQCDDTSRWYNTCADUXHECSZJTDUVYZBJJWRKEQHMLSTGEKAAUPPJKSLCOZTNEFWLQPXQEPWTDMNMVJJZRCIFCLKISBVYZGHNTYMPXLFIOPAIWAOLBOPNSKUDNQTJNRSPNCXVCQEDFIFGGNUTDLNSXNMZUEJSYHKIGJVPGDRFCLOTKOTZVGYYEWCQHKLCAIXTPPXKBPYRZLRGLTCLZVJVNWHMVNMFBEWHMYNUZEGGUBCOOYWWPCWIQCXAEADUMGBOGMWEMYBDVKEGCVPZBHSXFXGVXPESNIIQMPBVOLHYQXFECLBMBTHFVQUIPFKCCQPGYITHIUTDGSUILWJLSQAOWMRHRMIISZLJLLDKEQQYDEIHQUHCTWCROTPDNSKAHOTWJBNNDHTJQENHHLRDRXFDLBZROHSDUWSIWIRWMJMBAFMQZCHLNTICCGRHCJASITTKWRDMDOFYLXVWFDERHKZPRWNBDRULGECPAGVIYDLELKGJLYDKKLEZDJLVGUMOYMQPZPBHYCPUDJHZFQGSUXHRDOWLPHLPUQUHXUGGVYXWFYEZTRTTUOMXKFRWPZGSWBWBOLHUGJWCZBDUYPVSBDLWGVSFVNWCKWKPNDNWGSRXSGGTBTENPSHXJNGBQZGEYANMHTRJSUBFUAWBBKNKJARTPLNONISBLZNKRMYOLIUFPGOKWELTGEXNHWQRBRXUCANFWGREUBACBBSLGMRHQMIHMKOMTTVYLYVVEEQCSFQAGLKJLPJSFGQRDUALJLHZAMTMAQZZMEAFYNJBFFWYVNEBALNKSJBYQDXHXNHLHZVLZVAZKSYXLOITOGKZADPGIERNYMJNYEJSNOIYHQSRUKYBCQBLLDFGZEWUEIKAPOGNTPNWERPEBAXBJSFIMVFJJLABRQUUJUGIQXCCGZAPJKNJDCLNDSJXVDBEUNYHLWTNTQCIGYQXUMAFHRJMJZDXXKPGOOQZZAJDDALYAUPBBKPMUYTEYOUVIKTOFEOCBMXOCHHBMTCFQDVXTOEYICKAYPZTSDYKIXDKGGQCKMEGGUYQIDRRHREZKDTXVEQIUWRNKHZKPWYIPLVUGXDLGRWVNJNTZKKIVJEDTQCUSUYLQUXXRIRMHXSPXYHBIGLVJDDJVEOFTMOGNDQONTPNEXAEQYSHSBBKCHKZMAWVVZRXVUPBBZNPRLSOBCLTBLYHRPAEICKSJFBDETIQVAUKJRBRHYFHPRQQEHRTWASWEXLAWBCCSEIERTLBSDEJJAGGBGRYSKNPFOAPZIJUWXHFKOGYSCONWGVSKYBBXCVKXYFERSXLGOOGDDYKRSLMKBOEQNWMLDNQEMFOHWKOBVEMCUZKDMOYGCDSEPRBQTZEEBNQLMAJOCLWEKBRYBGUUDODAQVBAVJHZYKATHCDUWLBWCPPADYOYQFHLPLPHRKKPOVWHGBFVYUEYSUJWTYHDJWHRZHBVSJDTAVVWRLVWISJSCRAUYZGBVSKWOMMXUXHBIBRYAFMNLDKCNHCRMVGVZWJGABDEFOMOQXGVJPNQQMGHXDXUVIBRHPVBKHUGOPABYPXJKUNBUWDFSWUPCIZVXMRDKLKAVZXQYIBUWOQICOHIGGSGWTNJMHYLWRLNJMZVXJKFLZPUFQJRXPCXXDJWXGLSGKNPBPFGIVRCTOPIRWNRGWNPXDTQLVBZOSCTPSXYRWNYYSQNFAIZMPQSHLQMNUFUZTFPFCNCFITBZLXHJAUGSMGDCGMUGUKRHYNLVUQCPSFSIBAKRGDOEMGNKESLSKAUUACPCDSWPSYECBEHJKIFKWVGMARQXRSJILQVJHPGRUHUCDRBELHYNTEDKLXJBEVVAQPJPRVAJALLROATXFSOLLYFSSHINNHTIKSBQVHEEHTPVVMWQCPWPJBLRPAXWSGRWOJCUOXKZZTRBXNELGEPHXNMWPAWTMHPSSBSXEYFCPOABRWKWVPKLVRPALBHBZPHORMVTDYYODTDYBHNFXEASARUUTZILRHFNHCRZEYNPZJENUONXLUBMDYGJOSIBGAPUAVFDXOZUXPAESVOLCBOMIGJNVYVVBFOXXNYSJOKQMGTBKXCDQXWOBRURHSTRQBEMMHKDTXKPBRMJLBXDGBMOECVEBVDSFNFTWPYXHRFYRPCNRFKBYTDGXYVOHSIWMNLLIJJFCGAFKPLJPHKRVISDNLFZHMYILNJJBRYHXHPXJAHPYQKDYDOWJQDFCTYLSHDJKXXKKZXBKDNVNVWYAVCFANDZAUDTLEOUVMMUOSPBDJRQKMBYWPVATPIAZXXSVLZGCNQHOFGMPFYGNTOOUYJYCLWZPSDNZSDKXPWXNGCOGESJMELGVHVGUAYMIRBUNBSKBOWUEJBDLCORYZDXACHLMJVMZGPUHHNFYEATEMBSNVXRJAWBVLUIXZNQZVZXAZIVDQDVYAHTROHQNCNLYBPOJVXECDEUOLYJELHTXJWNEYEWRKFWLTCVSBFNSLYXFKXCWBYWFCOZDFMWQGOIDOLFGWTVQNUZUJVOQZGDIGBIUTHHLHKRATRNHROPINPFWBEITQCCRJBDNBEROGOOEXSLWSBUFOWBHHBKOMPIKJSDIWNFPEQSAWUCMVTLPSSSMTSWRYFLRCMDZCSBQGSEYHILMFSRXMMVQRLBLIHUYQVGFWIIQOBIPPAIMVCFRPKLFHDVVAOXMIWJYZKMTJCYUAOUTSORZLNDPGBRQCSOVRFCHPOSJJKASCKXCGWHSIWLOGPAIRNPMKFKISVFQEXIBJFEFYOGBMKNMAIRWIDJPORIZYWWCZPVPPRMZENUTXQUPWBZQVTKKOOWSXPWWZUQFOHEVGLLKVSSVDCZVQHSVFJGUAAXNVGGCPVYXZNITHVAQVREROKIQFDUWNTSMWKTLRFOGFDIYHWAQNFTXGQRSJKKMVLQEDMLLEDGHWOZHHVYHNUSLELHOOJSAWMLVFVXDZKFUGDCZRANDBVSOLAOOKATMWLHKDNCAUAHTUTLZFGVDEBFHOHWGODWAWPDUELBBJOXPBQMPIMHLONVYJNEXJFQLIGNPSTMZSEESOHMRXDHTUDMWUFFFFVRTSLVEIPZLCBMHMQJDZRKDKFMYPMOYEGRJDPSSJQOXHXSWTGVKBCRFVQVLUEDGYYYFWSOORFQHYNDIXDMJKMRWBOKGITRTBXSFAMTTHHCKFWCXONRKYUFIZFAQPKLNKCKVZMKUPWWGZWNUPYJZXLPBCCJXUKYZUHITLDJMBKUOPHAGMJOZIDAYIBKOXZROYVVWSBEZDJJPSHIVFLEXECRWYCYDQCQSFNVUHUIROMHXHLWELXVBWXJHHABGVGSAMYSMCVWZMQVDOZNJVKCYMZDEVAGPGINZYRDTOPYNOQFBHSQTBVSEHLKEMYAVAIPGRJWGOKGEVDAHOMQHOIVDIJJUGWRXIKVEGOZXXATYKZGSAJJRDPDQOSFZYQRDPEWBCXMBTFRWZMCXSRVYYGPWVQYEVYEYGSCMIMMJEKNHMFITVRVESVRMHNJZOBVUXFUEZRZXEMZAJETKACLUOMNSILVGZUDGMMVHRQJCEVQCNUDIPLETUQEFNFRSPBNSZPZGPFBXLYDCVXSHBNJLSZDTNFRBHZWBNGOEAWPLSJICGIYLYVMQNECNRGVUDFHZQTZFECVXJRPDTLYJNYRBZKHZCLDKRKFPFOTSMEWGHLNBOPREBCKKZQHWOSCMCALHWRQUIUPFXQQDRIYPHEGQACEGVUPIHXWRNZFKAQUPHRKQOGCMYKOSPYOFFWTLWIXNPENYSUOZFGBFOFDXKAZWYPMPZBIYDUQTUDRMIKHPXKVGPLNHKFVDVBQRIPNMIBVFQWLFIBNYWWPXCHJUIZQRUQLVUJKSINVZVMHZVQRUFQHLAVKBKWRRFSTXGGXLLTQYWIKOOJKTDNEILIDHLSDDCUUIXKGGOIGOWGUJNKEYQTOXFSIYDCBZNPNOCHIDGQRQRHHWSMQWIHVEHFJCTPWJYLBCREAGVAWRWXAQTUNQRPIZJNYGBHZRBSSJHKFIVGJGECNKTHZNCJJZKPEDBJGSDDGHNZZWOMQSKROMELMUTXDMRTMMCUDITKDTCRIVASCJGZIKEAYURAJNRXJBDNSKJYAIKQIPNPCXZPTFXSAMOZSNZRIVVZUHTEKJHJDHXHWXBTOEWRRCDJFNXLLKWREMNGGJSEGVYVUNEPFXJLLXERBXWXWRXTVNZXDRZYQYBSRCZJEEIRXOPNLDQCBJEHRMRJCGFWRKJXBHCBWOVECBDWBPKZJGCUTUARBABISVVGBPGXGQKAZWYQJMYLGECUZBGEGMKEPHLBQGXZKJKVYDVIOTHCGQLHNBZUFPFTNEGQNOCMCSQICSKGGIGQDGEKRWZMIGNAAYPKXFYAFGKHGXXZATQBOAYKAJMKHPUOYOMBZVXUZZXFJAVISUFKKJQHVWQYSNQQPZJWSFYLBUOPPRIKIEOZQBOWVMDZTMMCVYJAINXTCEWJKAEPWCLPYWMEAKHKEWHKUIFQYTOBMDHRPFCXZOUWTQFDWQPXXYGGSQJISDJXQGSSPPRTXYKZBBZRTPJCIXZMVXAJLJESMDIMMNKQRCIVRBGWXRVJKIQBUYFFJRWEGUEJPGOTQGZOWNCTNKNABGGOTHHVJRWIAFCUHWLCZGUHZMUHHFOHCJVDFWCRSEMQUIXANXCVDJXQMIUCYGLVXRZJFAVILYXGYRWJCHNRMCSHACXXYZKHERFKXERVKRZZGGEKKVLKOBJSTPVXXDKNKEBQHWMHFLZYHISBQVTAWWWUCUUDVTUJNGIFKYUSSBRANAFKXCVCNDICEAGCBMYPEPAKXKIXHCSHPUSBDXPCYLMYCAEEMFPHHBTKZMJSVIFSAHBRQDAFHNIRBRCIPHERLGDBWAXUEAEJTPLRWSRTBQHMAFLOXEKCCNYULESFLEPHFGHXGEPRUVZSSEPROWGQZYGBVIBHXGRVYGLKGBPAXCYFNUFOZUSCNIUXAAJATAJQOZCLFGRSDOXWCOGZOFAZSPOCIDFJPYWONMBZQRAEXSSWIIZQJKSLDFQMNTLAGIWAWERODWJNFALCFOEPMAJQNTPDDWXJRMVULWBRHKFUYZEGYKWTSIBFHZMKMGFPVTGCCTTLGUNWDTZMDOPQQNUARSTVNCABCTJUCRCJVBBRKHJRSWUKSFFMVLTGDZTRAONWUALYRMQQPUTWEGVPWFUHNEYFGQHFAJCIRCDEPOGLEOSHYPDHACVHSBYFQFPSQVBABUWUVPTEWZKXIVTSEVICFAPNCRFURJCAERQPGQAEDWMPHWLIVLWWRTVVRTJYDNUVILRWFWAUQQTHWSPCMUBQOUCARJKFDYIPZVBFFBCLNTCHWKSGIQPVHJKEBHSEXEMFSSOGBILSQTXZTYIAGSMNUOXIUHJOEKONJTXSNALDYXFURJCFEAHFNFHADFLXFIMVPXIKHDFPTKXDCZMMEDFQGZFKOPAMXZHDIWENUGQJMGMHOXCCJWWRGTYPMRBVTCORIHYOMFTPMNJQCDCANUVKWLPDZJYDNTOPMPSNEZHHMJKLTGVUXNEJLZPOXLENESNWQESIJJQZAKISZMWKHSBLWFKOCLAJVFKSXVZBBDDHHEHMGXKPOVADQNZZIRBEYOSBILMKFRROVJTPUZEKIVMUTFMIRMCXXTOWRXQGGDHKCPQSTSPTUIAMCLCSLUAOXHNPOEGYCVMHVTEQPUITRIUKEVIDTAEWBTMCMIGWOVKNPNLIPBBKRFORNOGTYDJEGRALXQEOEZIYRPDVNITXMVGYAQLJFCLYFFFPSMZKBBYTEFPOEQTYUSPKFHAJLEUVNMQXXQSIRWPYWPOQIPEWDNEZCFIJOIJNJKPHWNFRUZZRGSRKCHHTIRXMWHIZCGXRVNXDNNYKXDVHMTIGHFLDWPFKNFTYCVHFSJODTREHZIOTNMWDWFQTPFMLVAXTEKFOJISLRMEKHXAHIYJVXQRJZZICNDCHDUOTYXMZEWNFOJVGAXQYXOAAIYEGCEBZCCTYZUMNLGBHPNQHMHEKUSFEBMOIZUHWEWGYCTBLNQILCXIQXDLIOAZUYBNXDRAFFLMXHKURBXMKNFTXSRWDIMCEOBGHBZNIFIUTODWRNERKSJKGZMKMSAUMSQPBWDPMWGTMXJLEGQVMFXFVUAWRUHQNSATDJHTNQJSYTTGRZWBIBEXAIEAOYFHWPWFCGLBQKKMCREJMESFXNQRUJOOLOJQTFOKFQQUHPDVYUEZLVTYLEZAHXELYNVKLVBYKDXIDYYXAMHSYRTPYZTHPRIQLXZIZEOGVKTEUPETKSAQASVKTZBKDSMCKWUYWUCUWOBZRBUYLMBRUUTCJTDZKUMARTCPYNCUNWEHLBJDKTLSFZTKJAKKNBRZWVUOSEXVMNYNEIMXSXDDRTYXATZYQTIJWIDUSFZQDWYNQVPTKYSUGTNUMHMOICHIKOSEJPYIIHNGRZLDBUZEOUCVTDHFVKFSWLUXRMFQWZWSXMOGUUMJICOWIXVALCIYXWLNQRQXVVJNPBZCWLTLSLSFXOPJZCXKTNNPAVWNZNTGELVEGFEPOKKUHRYEYCSZJNILBEDMBWWGYEHEOWNPCPQRNDYVIONZWWUNJBFAMKLVEUJMRJHIXEHICHWZUKHSHFTQABAFFIIKJLVPUCRPWPEMPVTNEKKDMSGPHBSCTABEVUNLQJMEQOOYZJQOFWGSSAOEONUSBXNIJODNYOKXSSZJLCWEOJQRWXVOVTYLHUVPCUJKEQBXELLMTKLTFHEXYIZOOMIAHFFZEWUFYTHJFZQPLFKEBMXYZMJDFFNSEUEJZVPYGOBEJTBODCBBPJBGSUOXWYARAZZFKQAPZKPAKUFGGFMTNSVXEMNJGQLMDYRWIGAYMXBKOBLIUYWXYQLPVZJDXXAYMRMFPFPDEVNTNQXHCEYKDMHCCHAONXJFPDSUNYVQPJIGMTTNVKCCEBZGVEXIBBKNJNEXVBHCBUUDUEHVYCTKDLEZIQZQUAYITFHNKZBVFROXIWHZVGFVEIIEYYSDENSQIHVDEUKTJOGWUPENUJRMPEXWFFVMYEFSVRLQKADWFGEWCSBRBYMKPJCOANOUGWIOEEOVBCAZISUWAGBIIMHIUPFPNDZHJITWIEFUXYGGROCNNRWCEXWXWFEEQRWGEERRUIMJJIVIKKACILJXXRERPWISZQDIRPMSZYUKWSIDAULUBHCFURFBRYBJDNQQVFOXYMWIWHLAHDDZHZEUYDDBOMFQNOVIKHOIYWDCHTDYAYOKXLSJMIZDROEKYBMBACXHPPDCAGFKSRINFCXMOPDDFZUYRPMZUWWNDVNECGFHIOEJWXPKCQQUEJKWPDWXXWVSPVOFDKKSZJJWZIYOXKHQUZFQFVFQUNNLDQKIGDBNPPWUDMTHUJISNKFFTSAAULJUQWELVSPUNTYMPCENZKCXVNDTFYXFFSFKGLOVENZKRGHGDHNTNZWAMUSPYJAVOUBGJWLTSLFAKBUVWCVFJGEQFVQPPCEEAKRYUTRLILHNXZUZDUDJYXKMBNJJRQSIDGODKZSFXTFLXSDPECDVGWVCXXHCRIGZWERXJQQYRLVMUTFZBKFNOFBWRBMKEECUIDU", 1000) should be(1065)
      }
    }
  }
}
