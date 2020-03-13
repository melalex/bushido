package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.structures.LongestRepeatingCharacterReplacement.characterReplacement

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

    "huge string" should {
      "return 4" in {
        characterReplacement("GGUIVILPZJXWWZLVKETZWWFKDYCRQICLYYJDMRCQVCSFCSKRMKCFUNAECJVRLAIWFJADSNNYDPXVYGPNCLLCQJBAUVPTJCWEXATZVJVCPQWLZNUEIAUHYCBMFJSJJHPBNBFLKSGXQVQUBYFORKGFPPMIJNMSTBPPUBNYLKFAWDHTWEJKHNLOCTJQUKOPSGOLVYUQVDKZNEHPLRVHNEXGRPFQXSUUPWASPCNMPLQLPTUWNFANSVUEOBXPTRRJEEVIXEFUYRMTITPDNFYUVEMXZGMBTOLRWKHQQINSWGKVBDKUGQZSHFKPLQMVHUWMAVZGQJLTFHONMUSQUHZTQCKARLOXZETTQQNMKRNHIKOBUCMRGFSPZOIXTCLEKJOMMERVPKBLKATXOAUCAJNNFNZGROGOYCWUPWFSJXDYRIMLQZRQQMEISASTXVZQJRLGIKGSAEPGJAIHKFJFVNPAGQVTWIHKWQTWIGSSDNAPSKXWSOSCKZDSELZYQJKABUDCJIZGNBBAEVFMKXOQLZLJSODTUJJRUGEAISYVSZIHNYFDULBMEDDRKXTFPTJWYIDEKUSVNFIVCOYCHKJNSKEJNAHVZVVXKBSOYNXZVKKBJYBSNJXYTIDMJFWVGFVOVRDZSMKCIDZLAHEDXNBCZPJPZJNMEVYIMRQNPXVMEYCSJWGTIGHGTCERQUCMBVRWPGMFEMWBUYCXBKNERVVRKOFCJEZUWUGYPKTVBTRBIOTZUZYSDNVJAFDRNVYKEWLONXAXDSVRHXSMVPAJSXJNZFFQWMPEMHVVAYWIXHSFXZIZTCRCLDEPRWADXSDKTFVNWJWNIOERYVJDWRJXCJSSCTDJOFHXVSNHXZCXQNGXDWXSEPRMROPGDJYGBCDPFZHSJLMHFREFYDXEGKGDVILPDLYTDAPGUYGGLAECDMTCATVRNQUUKNTCYFBADMPGZJAIXNAMCPCCAKWKMRGKRUEQFXJRWHCXYXZPYLNGBSAAGBALUUUDMTSIBAIDVLBGWAPTPDGVUZHUXXYPLYWWBAWNYOQCDOYDIRFOFZOXQTQAQUCOHUDMBVROXBDXZQGTMUJSMLGPBEJCEYTADSVVSIEKIOBYHZEODBSAIYZASOKFOVVILHFRDHRRFCTOBUSQXKVSGCAKZPBILKAIVEJDNKAVEMLCVLOMGPKPHOAVSOFQBAFCMXJJJLMUVWOYBDMGBHZMUNEKEUWDCJAJRWNZQMSVRILFAQCUAQKDGENWPFBFSCETWDAQDNVLORCDEQENYPOILDWPIPINNEJFOTFIXNLJYSZMEBBHMSOIHARKXZLEQVHKSNEFVBPDYTCXWUEKIZLRVTHAUNYAPLSDIMHVTZIPCSKWHGMFHBYSTNZSWIRMBDRWPDINVIYTEELJHBNDBVAZENFHORYSUPJAOEKIHXSOVLZZCNEFXAHQMTAHMLNNHWBXKRWWGZJTDTPSEMVVKGAWXSCJBOAWTNGIQRGODWOFCIQYCJANKCCJOELIIDQVRUIHUIQLWZSYHRENHXQGYKXRINPTBXGEUNYIBZPMENWVSVOFNNBLJHJUDDJTDQGXNABPCAAAINPFRIFNFGVQZURJMFGCCYIFNJYFVZQZIELQUUSQTAAOOOIGBLPVOIQPLIZLQVXZGSWGQZUXQDRIBRFDGXRKAFYJWMUOANHKOBRMQVHVAEIVCRNQOAWPVBRRPZJQZSDLAANATNGWLTJALQFREICUIXTFSTJAYHQVJBPHAJOMTPBWAGANDOSGIKFJIAFEGRSPWXCXPPARWSRNRZIOFOMVNDLNNGCBVOOSPTFQQCNYDFXIZUBJUHHFZTYVKOXVDDRVICTXGCOZLBCKEHYAASGMWIBVZFIXOSQLUFXFMQDABVTAXJQILPYHTJQOSEANXYTVRYZWENFXTVPCZTXPOIYCYAOLQVYDBRMMNFTYKKMFXAISADZNIATGJAUUFREZGOGDJGGVYFKYCTORORXZFETRKLMSSZBNPLXKHPTDWAPIRJGKSMWHWDVYEPCFTMWXEFNPQQRASGBEQZOLLIYHVQDQWRBQWSHIKOBMXMLFOIPHAVILRXERYACNFYQIEIFNOEHLSQDTDBTAWDRJHMCTMDZLPEUJADTRTYGTFMNXXEYLNEDIDCUVACLDIOCOAYXPTYATDMXRZPQDBHKVQGINNHKALPPVPDZBPMRKCBZEPTMWSYWQDGWYKAZPJORYLENUDLZBFWOJNVLCKJYJWRXGWWURULTXOKKCISJBHRMVCELQSOROWBYIGJUHSMMEMCROQCNEBGIPZTTOVDUXYXSFPKBVNEHBMRKQNKUSXUSGJSTGJCDXZMVKGWJIRAKCUOYUEOKFRBJUMGWMUUTODTDMRCESDZHNJBAPZVGYBLBDXKXAXIRPMWVOPVEVXLIGRYMPMREHLWRDIAYWDYQLDUNYUMYWFSAIIBDIUNRGPGKUSBAGHRUTGIVTPTFEGOSUPNQLKETROUEAIEWEJBNCDBUGJSEGUSCXPBNJHLOHAALNCMSVKVUGCUWXPHEKAYKDJUYKBXMWIJRFQHOIFFVUIGMUOZACQAVBXZBWRLJJNKJSNHGHETXMOPDRRWWXNPWXYADMOCNCUFSMXDEGPTHLZZOYBCOAEEVUFJXFOUYVQWBPCSHIEBZWAZUUPAIXTTEREKYYTHNQUATTDNQFBBJIQDNAEXYPKRUSAEEVVCDAAXSMNXXDSPLWFVCZVUPKCFVNYMGKYRVZFBDSLORQXWIUEYOFDOVWOPLZKFWQYOIYAEZRQZLQKIGFCGXDSKKSIKHBYDMWZUPBBDUPUCVYWHZIEBYFQMJUWHPIOKWSMOSMXPBLFXVVLXMYKXKAEHCXLQWIYULQTNVIUTXTOKZROOXLULLCBSUEQKXVGBXHZDCZLKWTOXNEWKKMLFUWQADDPCGTHCAOQAHXKLGXUKJDPTYZTASGQAFOYHJMIDXMOWWJFUAPBXBGJEZJXWTWWKWHRXAELXYJXFRTJJHOZWVDCETVPVQKAVYPMYNGRMIKKUYQCHHAKVQJVNRQRMNOQYFXGPCAACCRBYSWZLDVEMTEZNOESIDWOJQVQGHHBDEUMNFKSZFMBMTAMLFRZWOCJTWGSOWDUWBJSBEHOVGMMNSZNBFGOMNAGGPLGKWDDALFMXCOHGHWKAGDOHBXVGRMRIJCRQFTMHAJEJKGIUDIKFGWGQSGKJBGOWZUVSJYYFCPAEJWNLWTGVQQPUYYEFFOZWXGWGSRYDXPUZIVKHTTULABWWAKISZGTGSNUITQMTLJXOYCYBFPAVOUAMJLUCMRAGXTJQKXQFJIMOMXDXWQNJOPWSPWXZMJVCSRNLZYAOOVDUVMOOIGKMRVADDRTQWTLMLPAFWSONDTIRPUAUAMPJUAZRLIHLGLUKOHXTLLDSGCQBZEWVHTWTINAVDNULUAGNNGIVWDOMPHCDTPDVGJLYLSUMQQSVPHNAETDGGIOQPPOILSMDGTOQZBZZLEHNOZHZCEFITTMEEVGHFKGVUVRMSNEJNVTLVCRKIMKJBZHBJPJEDXBOFRLSAMCNEXPAFXVRUORPIFGAMWQPLTBGQLUBYIHEPWSLPEGHAOEZFESFBCZQQMYRMFUCDZXPYYVOLGMHQZCCYPDGCQLIMJYHXWATYEVPOHUJDHJHZILPBOGJVBYUYHTOCVVECOBZPWCLVCVMAUOGIKSEBLWYZQYCNPECVOKFSBIYTPHZTVPQTSDZXULAGZLGGHSSQOOZFNOFBPTENBHVURGFBKXRGGUKFHGZIIEOAXMCGHJAZQMNRBHBOZWDXLAVMPFTRXSGHOHSEPRNNTAVYWSGNUUZFTOFYWBVEQVKSBUXEUKPFICJDPLPAEVMKPNNTPAREICRASNVGLGFYYKRPCMMHPDOIZFIEFUGPUWTBUMFNHCEJJQQOKVGNDWDHUOBYIYFIOFTRDHFIJDCXAWPZJZWXRFFVXSYGBSTFRFISCKIPDDXQLMROTOWMONTULAGYTOIIPPWFTCZSKXPPKJGTTBTJHYFEHEDECISNZLRIGDUZPTAYSKDYEVVJGCTMRKUXVTHOIZZJAEULSVSHGXLGGVCZVTEBJIMFNVXEXHBQPJILRPBCXCLXHDMWAHSYUIIWUXHNGLIILQEXDPJKDRRTLNPFAKORFUNIUQUNJBLZIXQRMUQBBWUSLUDDDVPKAMNUPAGTSITEFWEHKYKANXHLKHHNBAXVRUNLFYBYNEFUVWGRFBIFIAJURNAYYXKGOBSRZRWCIWHUHQJYMKEGLGCVRWHRRPFUKNNKRAEIIDSMUYXYKIMUOERIOVMLDUQIFGHENAQFHEPGKBKGTQGYOKZJDDXANCWFKRSRWAKUNKKLGXTMUANEUSAELWDBRBLEZRMWBYONUQAHFBMWNDKCIXHTVMWKVLTCPZJTTJNIVDOSTOXHRGOQULDXYEWBECOGSQHVVPLBTYXEFGWCDHFORQPLZVZPASYCDDDBYSERCZSRUGJKSPDEDQPPWVXHXYRHBVWFQTQEADIKBOSZIFKWAEQQLEFLFUTRVNUWPZPPRBXUUHBVADNSJPUPIKVORQQSOYVLEHUDCJUVDMTQMRAKXDMIIDGTUAHHLCEJCTRGZCAHIKCTFLZRTDMTFWQGIIVSOXPBQEQTOTQEMTMDNQCAONKUFQGHGYYANICAWWSLZJIICHYPLZOGCKOPBLJKVJTLOGTPYQPYDVBBYECBUAFETGUOMGHYPMSNPDYQWVBMYGAKCPWLLIYXPOFRCFQDLWYMZFOCALQOBQWLTKFPGKFXXGVPJOUFQOPBENFBJTZQRAHGPQAEUCVKCVFQSXZFYZFMSIRIXGCHBRXTVRCYMHBLMQRXCBPOZHIBUDIVNUQCHQHHLJUKKFTYJCKGIUXNDTQHAJSLJQBJCVAQGYAOZZOOUGFZYBCECSHQOKYGTTIKSYLCCFAIAYLHEDIQSSBGMYHSMQFZNGSDBNFORIXTKHRQVBIOHVLCEZCNRLBVJAJVUWAMJUMERWLDEZBABJQZSGROERFZBUSSLOVPUPTTVHVOALEFSBPJILYTIJKCVPEFVOJHLSRBYPAQAICBVEAXHDRRJPMFSBVVZSIDSTTWQURBPAILAKFVZMCMFFZNMHDFDOGOMOKAYNKYWMXWISGSZWVTABHXZGHCLBAGCPECGXLMOCGDUXATITPQJJNOGNTQVFLOLNBLQUSVWXDNWLSWPQMVQAXQYTEJAOJGXNVQRUHCRVTZFBQTQIRUFAMFMZNZOLBZSPOOFCQNAQGMIKPNUVVNHPHHVQWKUMWMIICPYDXMQHKPAICYBBXGJYACQMJSJNJQTLCKKTXLKOQGRVXMMXAJWORYLTEHAQUOAHHWTXIFXIYNHKILIZKLGGTOSDVDPXGVRSBAEQLNHFIKPSADHXUJZDWXYGPCHFHZPQRNFBOFVTFJGEWKFKGIMQUPQINJHOGNARVQCCFMCIQLYCUGVEYBLOAZTCOFKQKEWWQIUVEJUMNWFTLNZNJDNTXUGRZLBPYCEXMKGQNUEARXQHNSKEOAXGKPNCKNRUHORVHBYQOOKRGBSLYDVGCYZTSGJCNMZQGUBSFNQHDNWLUGWLSEGUTBGJVYMYLOOVRLJVZDLJSVFCFAMWYFWFYOKLYJCTSYATNYLQXONMFHTDCHHFUOIJRUMBJCLIPLLTRYQUVQMGWEUZQYVDMPJAENUONSUNXLUSOBJIYPWTDPUWKCGJFWPOUKIYUUXORYDGKNSGPBSPTAHHJUZCNOITUFNLCLCJFTYGKXQHAPTHTTBTJWBZDRBJTGUTCBJMIYVETCBZAHNVOILBJKYJYYCVKWWGQFLIKPECOKSEEMBDWRABXMGVBZQWFYCBFBUMKNALEOBDBKXOSQRQENKFFJHKUSKQPAPQEBKOLICBGOWRYTXQVMWODJBKMCJMRIIJIQLQLQZLQBBGVOYEVMZBDNTQWNWSMUNCOCYBJIMRNQZHQUEGHAKGPSUFUGPIKLHDOZRCKZMLSPRWHXGUCFPTRLGIZZXVZWXBQHBHMRQWVUHPFREKFUZCUBEULVZLRZYVKLNXLYHDRMIHDDSINVAOHTTPUJKLVNAAYJSPGODSNSANFITXTOZANRBLHQAEGRPDKZOBVXXEZYKMGHIHHESBMMHQEEOOMCLRMTLHROLPBMKEVGMXXJADOFTIOBTRKZEMIEALBHWHMPTATKODYHTFULFCIBRDTZWZUFGWNGTCFZCYISAXPUUSNCPFMEFIPYVWRXJUBLIJSFHAQRNNHKXMDDVLUQHWCSKKKJFBEHKLMJZDEPRZSMYFQMIBJKDYIZDUFVXCMYHVTIHTSZCVVGDKWDQEYBQTPAOKPPGGNYWPRIQOUZITSPBAHZHTRNLPNCSHPFUWJJQDVMZGEXZIKMQXHOQRCIEWQLUQVFLELOUFYMDJFVCJWJIVULVKAZBHRPSCNVXEPJHINOWPFMEUSGQVMXDBHPEDAOXWBBXGUOHVINJAVTVXDVPVYRDOFENTCHZLMIOECLJRXMFJAOFHAZNZAPVQZEMMTJFDJIHURPBCCDXHWNTMSGYQQGLOGRPVGWWJFTSKSUZAKKTIEXNEGVADHGIGSJQAFSRNMDVLIZVLIPJQJZRMQAGITGCLMRALDUMVRUIRZRIONCEQDAWEOXMCXGOTKYPBICDCRJLDEJDWREIGWVVOKYOCNOQHGWNDELTIBCNSZLHZAPRWBRMHJQKCZSTNNJUQIIFFVPXPRXKUQVNDEQYOEITDYFZDQRBNCUEMQEYLNHHELQSWXWCDURSEQBUWKRYDXBGUQMENGNLGANERVIGDSMCJSXGUGJYZSRDLBUWGMBBHWEBMMDIZLRACVKTTJTJYNCQHFEBIGTWXRXQMUKCHJQNKZRARDXHSOSLXYRXDCPKMUWUGMFGROFHQPAYTABBZEFUAVVIXYJGBJIXIPUBTAYWYIKRCNEMIVOWFBNLTBRRLNRXTQEHGHWKYRJYIKFTSKAHJQLVBSUUPGTBUVEARNFXIVULOTNOCFDIMPFORADOFOBPKIFXRZZCANBXNTVCCGOLKDUSSPWIFVHMQJCPGHAMOHBEDAXIILTXEDYBUNSMYYITUCIVWJFXJPZLZZVUZIOWUQQUZEEGODVQFMDKDPQPPSQTVYVEYSAIPTCINKVWKVZIZPSZDOCFDHHBVWLNDZZLQPSNXKJBERLORWRKIQHOOXOKBODPALHOVMDIACIBSUHWPIAURJDMVKPNMFCTSVRKNFBTARMTDCDZKGNHTUTMTJFICCCSABITMGWRMUCHLQMBXHUGZLAKQCEYZUYRDYLLCHPGVLJIRPTRHYSMUYKEVKOPKMDTDLWPPEIWJLLAGDIOTKOUXOVEGTHDCCUZDYLRHBNFJVAXSKRIRCZQQOYXGEJECKZDOMWNVLHKYBDKRMZANLUHMEWOTEAKCALXPXUBHDUQEXQFQSSJEQUBHVCHRHHJNRHLYJMQJCZMIANZMAKJPHOTMTSGRYWUJGQNYYSYCDOOYGVMGFCVKMJNLKAXHCZIOSZDKBZOTQTPESFKICVKHSRTNYNDVPFJOVBWALBDPQIJRYKECTTVEUOXVGBFYYLBZDITKPQIOSOJRXMPMVTDXFMIJOOPSTYKZFWRLJORWYKEXDNUTRGHTTQJDEONAZEIAJURXVRFZJHCIYOJCRQMUTLOMGWMYNZNIPNYMCUXCRIPJNTKXMZRWQVNTWWOZTPYUNLRXPBNUAUAXOQEMXJMVRUNOPZMGDFJUYRHXTLKZPIAEWWJYPSCKKQTKYNXCISUAWCQPBZPLJJINVKFNQTPLZCWIFCFUDNTWBDHDKNEBMMDERFLZIZPUYIQCFQPEWZUFMHSKPUHBKSNWCYHGKCTRYBRACSLHGVHTISIJBIDSEGXYQATMJVPDUSUVELXGSMCCOSADIKAHNXYARKGQRYEJNMRQARBBTPOSOMIDKIUWTMSIKHLDMZNTPEHKFSZGQKMRMLZXADOSHNKOSGGARFBCAZVQUXILUCGZKCIRDLEJACGZEGXOVVNIECICBAGHZTXDXMHSHSBTXCTBOQOQHTXLLLJEMWRHEIWBOPSUVXZDJOZRPZLVXVOEBXXTUXJANHZJXCFKGYEDWRTQTZMVIGNXRRXIKFFTJRVQUTALBRSSHSXDBAXCTRXPXNESIKFKMZFRBVXBZUOBBWAWPOOFNVBLOJDUAQCTMVLIVTXMKQSTRTUQXTJIARGNUIDDVLKBJACZOPSUFDBJFZSQBDYVOZPFTXDMSMRTZKYJUNYCFKZKHOOBEYHFLTIEKXCRLNZYTOVZKBFMCSDAWEBXRLTAVOAWKSSGFXZHNCOUIPXFIVKNEACZJUHCHUYZJZIVAQVXDYDLZMLPGFIQEDITULCELTSKSJQKWGJUSQGIYUNTXMZHJQDRZHTVDOTXFBVVJRJPFYDGCPQZTYIWQMULIPPXNACUTOKJYBULGOEXNBFUQAEBGJVDHJIHBOYJFLFMAGPBJADKHSNXNHJSGFPBXPHGQFTGEKOBPMGTKYJLZWJUYXLGAMFCFWREPCMWLHSVMAGUSXTNUGSCIYQAWVHHIJQNQXTBSYNEDRDJRVJQFMCIJIXVJKNSZBULKCATAIZBXKLUWCHCKEUAKLDFBWADPMYPOXCDKTVCYEPCQGSEIBAKELDCWHHMSRHKWLOVZQDADNWIQYFNYOMJHCIUGRKYDFUTILBUCZGKJKQZMXDVGCZDKFXYMISBNMKSRUFARSUMDSRENQRETHWIJDYOSULKVDVAKDXSKGNSHGRSJDGNFXSOBMXTOEGIHQKWLEMSUJAKDGUOLYIYCVZXFEHWFUDLMCGZYDUAJWOEUQPWVHDFRZAGBFVGOTIMGXGMRVSPVIOASOWGADBTCWAUYAEOVLKMJBBZRITWYKQJYEXOGQLZDCNJTFYRBGZUVYGGUYMJGIDQWNOQNZAIRSLLGRODNOGIPIZUZOELXTZZLLUHNPSXKLWOUFYNTTUFMBMGWFBIURNSAXMOPFTWDSMANZSNESOYQVLZCOZSGRSRYOBSWVJBPIQWFXTEIRBRJXXXBYWIYWPQXOVNSZHZLPXAKXSNJEWDKRHPMEBGKDPZKGSCBIMOSSIAIOTCYLBDTWBIOJTOJYDEDDPJBNQLGGVWXIJGASJYNWPSMBAHWLIYSVWWATJMGLXTORJUOGUTZJCLSIKGUWTAJQLUODMRDSOXTYWENOPFAYJLJCJYWCKARVWGMMMZEREZZRZRIYRUVVICJCIWFOBSHBPMIIUHVZVWPMHPKZBQLWTAZETNVFVVEGMBNFKNOOYHVHNNWJNDOMGVPVYRCWVWNWXXQUAEZZVQTDYNYTSAJCLVGDZSQHNRDBPVZUVOUFILTIMAZXHAKWZAIDETWXQXKFOOFAOUWSPSFFNOOMXWIOHLOUTMUWHNARDGPTHNQIDSGLXAHTWSUMTUHLIIWOHZPWTEHJBOEBUFDODRJCHVYZGLTEIYZXDZVTHGOZRXHKFPYHIZOGQWBUGTJYGYNNKERORDYLRPRRUFDRIEYZFSNVGICYQURXDCCNBZUIARXWUELWQPCKERYMKEAZPMPSJFODLFEGCVEZXEHFTJJCFHUXZWTJIONJPAXARJXBUTJXNJDYAAONEMLMKFTZNDFCZXNNZPANZXFSFDEADRLOBXYHOCWBNVEIYEEGXUFAJDUVIERTSSOCYXMKUBUOBNJLXQDXYAKGEVENKYOMKJIPXKJRVINATCVYEZQFMQTGMKVGFGALSMCCHFIIWDMAWZGHOZXKOAQQFGQQFKWPGVYISCBOTFJVUEAMEYEPSPMXRCWCKFYUUXHHDQSUFCZPZFTJAMKPKFYHHSQJGKIEGINKJLDRQXCRNRXNISLXAVNWRKOVBUNNYQRVBGKCISIIRULWMXEUWXRRJNMZAZJYEIKLUVGNXRKNRKTBJRCLAKXPOCMUEBUYDNLMFHEUHBADMIWYFCEXCFTLYJRXPLWYSHIOLPFKHBWJXIZTMBHFOBZBYSFESVTSBERKIJISNFKYNBLDYTFLSHGVKYJSOWOTVNCXV", 7520) should be(4)
      }
    }
  }
}
