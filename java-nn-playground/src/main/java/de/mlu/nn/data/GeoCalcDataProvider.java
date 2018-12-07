package de.mlu.nn.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GeoCalcDataProvider implements Iterator<Data>, Iterable<Data> {

    private Data[] datas;

    public Data[] getDatas() {
		return datas;
	}

    public List<Data> getDataList() {
    	return Arrays.asList(getDatas());
    }

    public List<Data> getSimplifiedTrainingData() {
    	List<Data> dataList = new ArrayList<>();
    	dataList.add(new Data(new double[]{5.47315726953888323387617886826597719053,1,1}, new double[]{1})); // nah, männlich, A, angestellt
    	dataList.add(new Data(new double[]{1334.65600968212532725897876338494769069,1,3}, new double[]{0})); // weit weg, männlich, C, abgelehnt
    	dataList.add(new Data(new double[]{818.138328203222325512210190734786383956,1,2}, new double[]{0})); // weit weg, männlich, B, abgelehnt
    	dataList.add(new Data(new double[]{10.8135400871143509879898643117979734785,1,3}, new double[]{0})); // nah, männlich, C, abgelehnt
    	dataList.add(new Data(new double[]{11.3194633540567320255011388002508619904,1,3}, new double[]{0})); // nah, männlich, C, abgelehnt
    	return dataList;
    }

    public List<Data> getTestData() {
    	List<Data> dataList = new ArrayList<>();
    	dataList.add(new Data(new double[]{0.1,1,1}, new double[]{1})); // sehr nah, männlich, A, angestellt
    	dataList.add(new Data(new double[]{5.47315726953888323387617886826597719053,1,1}, new double[]{1})); // nah, männlich, A, angestellt
    	dataList.add(new Data(new double[]{1334.65600968212532725897876338494769069,1,3}, new double[]{0})); // weit weg, männlich, C, abgelehnt
    	dataList.add(new Data(new double[]{818.138328203222325512210190734786383956,1,2}, new double[]{0})); // weit weg, männlich, B, abgelehnt
    	dataList.add(new Data(new double[]{10.8135400871143509879898643117979734785,1,3}, new double[]{0})); // nah, männlich, C, abgelehnt
    	dataList.add(new Data(new double[]{11.3194633540567320255011388002508619904,1,3}, new double[]{0})); // nah, männlich, C, abgelehnt
    	dataList.add(new Data(new double[]{696.086100987356636516170572383643203998,1,2}, new double[]{0})); // weit weg, männlich, B, abgelehnt
    	dataList.add(new Data(new double[]{65.1497036904042081045477023568297712541,1,1}, new double[]{1})); // rel. nah, männlich, A, angenommen
        return dataList;
    }

	private int countAngenommen = 0;
    public int getCountAngenommen() {
		return countAngenommen;
	}

	public int getCountAbgelehnt() {
		return countAbgelehnt;
	}

	private int countAbgelehnt = 0;

    private double avgAngenommen = 0;
	public double getAvgAngenommen() {
		return avgAngenommen;
	}

	public double getAvgAbgelehnt() {
		return avgAbgelehnt;
	}

	private double avgAbgelehnt = 0;

	boolean useSimplifiedTrainingData = false;

	public GeoCalcDataProvider() {
		this(false);
	}

	public int getNumberOfNeuronsInInputLayer() {
		return getDatas()[0].getInput().length;
	}

	public int getNumberOfNeuronsInOutputLayer() {
		return getDatas()[0].getResult().length;
	}

    public GeoCalcDataProvider(boolean useSimplifiedTrainingData) {
    	/*Distanz zum Job, Geschlecht, Kategorie*/
    	this.useSimplifiedTrainingData = useSimplifiedTrainingData;
    	List<Data> dataList = new ArrayList<>();
    	dataList.add(new Data(new double[]{5.47315726953888323387617886826597719053,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{17.8511684898989849971185240972534544339,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{77.0958811019467840842556931206062356173,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{13.7341863963439361288026099767957993789,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{355.306572185851781774669899672070058569,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{29.0479795326545643894021414178627276348,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{71.1516914474107672365707503647221909327,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.4585173261561323105691970252686428787,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{9.82491370828137265022919291641045581387,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{19.2897665556283886804264464003462822272,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{7.55100594304712305109421390979429241802,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{21.4840485158444001083120572196238056454,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.1908503943788565751144810810083383273,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{18.0232334100685043313843874819863180634,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{26.7222753869280217755325411500341533353,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{34.59247373471760072360196259377655925,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{10.5008345937977420518281015990588866559,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{525.344405777402541404427020273665971925,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{23.3818874318021147464368801667202138244,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{17.4851737896943295319761400247853000643,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{7.75278382617410641341085809915841222253,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{16.1225900582914883060142942254507670354,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.0580501959501959700052325821597036973,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{22.9780446255237768909929505177257341866,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{75.5058953957723785610568442716541609741,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.1577146696353606500700220747714840237,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{725.771364681612689686375705255294538748,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{1334.65600968212532725897876338494769069,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.9103393244075537348911898922405306164,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{45.6039234285306800831599684698281554394,3,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.2590910462136618965946423763733246405,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{28.6608615171534016292739974086538628697,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.84771012559297388311709905747866842648,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{818.138328203222325512210190734786383956,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.2301580412536094046633525084815135741,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.8135400871143509879898643117979734785,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.3365542531847793281328203779241614137,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.714466429796501432663954586853045358,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.2082774282914873484330647252124893684,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.6424833242590149777114194367876014292,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{106.122691383211944639562583397781846971,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{28.6692479730986998710859142801161373031,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{16.8993720565733048883350844766700837016,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{32.7334438293089550501746266406238517695,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{69.6689817521166741525280178170345276296,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.2172919900631625702688427521131301677,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{14.3374925754818998814618381485070508794,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.9146324377363898950828439467459213718,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.9735241066952224210910579475305390412,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.5600820939056654305400543435124690186,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.3306672566713786913919609169343511357,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.9379899800198608540146851838521010469,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{16.3365542531847793281328203779241614137,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.6081584350034356670989458834964763797,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{366.420544089026929604260790514503774485,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.3425780094943547079368497217843046786,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{236.117890099736675453944567408939109176,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{239.612021157957430859359268688459908285,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{34.9466813917734581111051393876023459925,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{25.8340218430528070322168159843149890691,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.778454444278803133679104673213240025,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.4305474576718402059698608449154189301,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{38.917314480888610717176874949557522838,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{20.9869024099678113598511702456385524252,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.6910287639943223009829556270002538772,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{366.420544089026929604260790514503774485,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{42.5117285447468368128218438773439291915,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{141.753593441020326672778730668019075864,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{366.420544089026929604260790514503774485,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{366.420544089026929604260790514503774485,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.5849665810453260772681585877312339105,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.9570351341974184270613028138922907372,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{366.420544089026929604260790514503774485,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{46.1786378403346235861353111148083189555,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{31.1517604634934550841648660721705488287,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{48.2787216484878033915999479944719738571,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{50.4810037037510417243695413866192088262,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{38.4971899274350228226463196273002563206,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.8732711549040862478077042167512802208,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{19.7433964387186441844278170057325051467,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{.67474078628630417693058165121102827424,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{96.3085833630861818809428034813136708187,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.75818978743711766312237437534271062162,3,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.4180002676604193148463401469073780174,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.38277503513249264966180132740968450723,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.4789398483974906765134793539000474897,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{48.5063168174282550690011003100591460014,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.46696504908141066229921789249308931877,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{53.7830984259511732959300007071970348608,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{34.0051906481272492181694788988718379714,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.4028190828670406257615406867794555521,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.8876646475749927574229347659995159236,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{40.3324597337738789906001115151875261208,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{47.6649715075495468255397429539085237926,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.1296541341282599879047149659302951497,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.27300985146801801125206248677643302796,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{32.3299572064422379014218378494833137028,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{36.1423440666673004295234805575323212921,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.0395394288636315601159009630957908111,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{38.8539159908702762353698101610153933867,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{38.528441206590848055999632425783490666,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{34.9618337467911999466767771534826620486,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.219961356079089371105840227074558943,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{40.2144830569384500947424357120152976247,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.39722592972182219763529209043718964083,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.2596858054195348015863413188112938185,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{61.1267943722524693374649899574767038602,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{35.1436982425138890156147452180899670471,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.38277503513249264966180132740968450723,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{7.39208859712895876764937217892312601583,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{64.5748991818567008179267276212083485231,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{15.8111002009139900463482746959745716359,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{45.4380458654503338979225430531367566391,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.721365810370665950093069485120675604,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.8488187101675378792871948184245098528,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.1643005139811365176942938628445738923,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{79.9995533137604195999663941306385234656,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{61.8512869020113650624166326665295167619,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.07438291355358435871488686523399867605,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.0438951424807661751232661436682013356,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{25.6962074201022176014727065584213012195,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{7.56373065003149503516836141211959454428,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{19.7442298668078017199340631399526670066,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.0401590838565225580229967419678262394,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{8.8002787198409437880448012220741454312,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.9338207279937292048903899312012756613,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.5222743083525980779296037631109853604,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{231.668975995687070090989382373207632367,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{11.3194633540567320255011388002508619904,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{105.887225487509395187837899236514614346,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.43013583401277126741494952315729456741,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{27.0376624425400994892088409185926889511,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{66.9970143606617734878686151527406575285,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{51.6612343181506510326984954461829315411,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.2503543356450085046017610674241655778,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.0468754798491053765578106298944853557,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.4014740997243843233490112734347459001,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.5850582369022051273368969624285652782,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{273.454980163435647774851040700324766168,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.9845452595672722587923332264390691266,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.4625505793280637434860919251134266853,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.51266688958525831374683978865458371034,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{13.2366549786204795020065835856445045859,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.7756409489177493184726773060547618432,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.1185623134654119057467992249322272272,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.0138921498035183303003062822148043453,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.1461034510552855556160821239747950292,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.2520371494731123454708282926038999756,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{13.6175530787477075876753338879839620923,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{63.4852634043377147681180537846244464451,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{117.798104996210006626082495058709499409,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.43800552303747336298073828636698467342,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.1046748061848797853071184357079063089,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.88399786754517507465992217991494840785,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{83.6087291138957946355693828499318835957,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{29.7948160192833044227164317302127475934,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{24.3821244932230551225896304139519933667,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{53.0591891510954428026541191930550713986,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{52.4073928570556964204708626523819458603,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{32.1370415390271895197984644375779016405,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{56.5253526982648372971482758385369517785,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{36.3832862553369383000153465381009770869,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{62.5511113273060149358763282153322184065,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{54.404998798359314796553689165498903616,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{51.6909751684540258432673334642481589818,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{36.7434574925644364444308756894464187274,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{54.9138274283237414806849178616388687355,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{43.3567479227020980653821325076755617807,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{37.6843623105011906643531381209153547958,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{32.1826030623987203497083117180335456205,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{18.5455041593181735477999231791513387876,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{53.261446470111115324452009679858933961,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{20.4604529272323952766249967548578790101,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{42.6874127735787928575809703021933653261,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{21.5896740850861006283024915493378343799,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{52.768443373971118557679194807423971878,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{27.1104342403380425519947256441877200872,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{46.2425891480301023648895520733956153783,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{79.9357601594531417805435105401618503814,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{41.5582997333031450480892314935971482848,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{31.1922271499832724424945258489369436159,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{33.28899357838103223614523569024066275,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{36.6064526401655753061070985236779703557,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{50.754392254181192268994455325359950111,2,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{48.1601717110515399372329412948585172974,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{53.6261339674768973789483932442067184163,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.67750107101436637967110570704637518744,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.22012638075720393590595800035476134539,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.69634286561120231332079036473396575784,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{.637338313303826321130918264110190924788,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{.977377726373008256324343096598105209208,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{33.4265249132701715195433579606888295876,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.331428617992596454801605276452254098,3,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.9329864172403925023236464169376930177,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.2149246041092522437742756151394740146,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.2149246041092522437742756151394740146,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{26.0969634591429937769368700540027790295,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{87.450264537639369777462293879133691865,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{4.35708378660652628361940184263974892298,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{61.5332308556973165541847678101537315182,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{76.3121944643437415623795848762454549895,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{114.841874573541160294030734298550945586,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{45.3221291204588339699047346264124395832,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{52.5978016314949743774596841244470751204,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{16.6003497365153414835279275595679733394,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.3817719630598671867481506080263124234,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{35.2907331188782014165142987857883464936,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.78708011561790276494474609396865194556,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{10.6735273940130493585055090094845106977,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.0627455897420159033566278988617783969,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.46962279083823493466772448902506378805,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.91523893495656071713064099563465270711,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.9551010250125567652724346732119605686,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{696.086100987356636516170572383643203998,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.11546225324492081333230324733710283114,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{13.8568841643957235350771547378616616444,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.12552163745355769930493214166500609396,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.2920379404029642222489513867951488427,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.12244334227240782771185309917848975616,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.9530439244778972392543006273559032533,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.36895380173961031105549254479897573448,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{61.2081691239489950479746920290397787553,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{174.236380592697140791586806401250323316,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{179.417262126667271936060141066142431278,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{88.0900202689217309758373786441264540304,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{65.5188601020317719747611547572677882011,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{108.773336888587365627599173124211066048,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{113.006487118076448979255011676236222762,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{116.818371000841403701829515544833330109,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{105.917146689565239062358670567951041303,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{101.605274694626178021546220860859366963,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{108.28586588860770141473716074442274155,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{100.760941109231856581399295678484056501,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.73009183105954291473785233376899854299,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{2.48962702731317317152406512297251879711,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.8816093758405657369501485314820880527,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.7348286856948941315993216575790020872,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{106.524196734458200810270656215360615482,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{31.6495397180854388577886852841359753285,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.7680274706623651964269734640566638725,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.0992611126981006020912355499553290436,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{62.5616566467321792561918003587695734341,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{65.1497036904042081045477023568297712541,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{127.21078168953435649848246529498005886,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{69.3454966897674703892873866486133884943,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{33.0384866825436685851928096814157627129,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{68.5025774002181864612550825501409964845,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{127.423861317032007626226968606389515824,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.9779000988967370958886576899806307329,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.6788061749584720961009297828947766294,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.56496437047634818797233082717818399877,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{13.8538608965835239419717603177721804561,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.9286215240933005493064884755690133268,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{89.5137479868928270052047214168053853202,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{26.1862322771082719141601177169044693024,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{89.5137479868928270052047214168053853202,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{71.5571511921036844526767828443378104203,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{14.1242324686443464501987344903437955999,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.5144023253531935171943666333234412491,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.4142569741999690735779355951013207411,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{63.1278458945420281979121641522519575848,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{163.283160711760310647517355892406174831,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{120.896652647936957269292505522793259752,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{38.177047475694738403120057220991936353,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.9255651149519346812991218723367455127,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{32.8419548111714075226548584629950796178,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.91908799171041750586520866955423527369,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{24.7027486617024398992232782189818165816,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.66145932244662390082694441700385069875,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.751825145646188803486600331518119679,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.90740389617963653052180889236736839482,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{63.433930514562080284807762504846659574,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.5110542427113895290123294381053506701,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.9138496309622901343930840459484164514,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.3165195365440351271145818515386942387,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.9138496309622901343930840459484164514,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.9462588373481117536470996166657126957,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{93.0304234935027709420078864106793591014,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{4.03355356567710403008630521471662718447,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.22626171808946689382089129712903106,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.25071510652243893948636729070358668433,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{3.41061606466573241874699773111500189623,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.70019979598833701321084679313661256944,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.69678929881728110911273364406948324553,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.41350104225179955613266278751886198963,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.9482441344086485821084137662185103719,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{34.8490621498546682180419340642892606089,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.95715339665717471464802080339408347562,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.36778846680619089488144299314478795901,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.8399598390915014149468919315880266731,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.33026423353834783775886573084133338646,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.6810634886849692460339897097963951261,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.43279324407818956248971587315903718645,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.83532682361032394355872016236300549994,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{13.3310726420422565497712515732616050283,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{20.9804740670503989776419904711967191159,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{26.8520786726165502345040032766466221366,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{23.7062171825693754986521893707601976665,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{5.65859961399962614592914223452482915957,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{1.75358027156158881815155922403233482826,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{24.0778034893734193081259126234475228758,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{25.7081375878098518111082258124236795651,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{44.1971566775262762576177521584573948498,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{3.82122559340331730395026479171988556611,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{24.6067485298345831643342644131661840041,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.2374079802020020904556442399474837645,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.37982124741655893473218161996009703847,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{39.9159907083300893309576686831076936327,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{60.9865072529925163707240276435752776017,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.5152718678320039469300495129694242026,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.5084107382273791718907037130139470651,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.99080560648976678226320141957762919,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.8636094024463457036095069968450326382,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.68621922792352029850067863063345384163,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{52.8495380422511969123025125184410637937,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{120.422653301681610353456508025910158267,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.5310470350083932760164328565785880217,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{55.0929793896842393973035725002059858285,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{51.6311135189541848576032790215975775634,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{39.1771074905159025949735540230029668033,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{34.2264759887256482678478377494619982859,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.20530224680942636988256475184236466022,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{42.73637243067474191308819088067343197,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{27.5220888841460464574764236414257789845,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{43.6617084122748254851288794101172924768,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{41.3469073155071614045314185838175094378,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{163.542741524784141921204150769897093577,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.57328177216116318049690673605519757923,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.7521342782003434385944476671168072472,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{43.1486556292782899307154972646936696159,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{38.8154635856844350764014027054457415189,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.6598778950311765521191141028009383106,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.32562578627024408248007801568297550466,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.7117437993904302405974715975401835177,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{28.0834106580793686523952977015486640196,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.7180521424770237856955652874864057724,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{48.2103461362375664217140297537896390698,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{10.3961048793805326626269404670626436542,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{18.0848788242270248200334922660887351852,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{28.6608615171534016292739974086538628697,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{18.1882463099584185295760647922487828079,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{98.8541892621532878688650151847845542225,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.266091505171441410645516764776048601,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{44.8101421834336733440291400765208544023,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{57.3736897356920211062814790754145524236,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{69.4472969156008153381556031602251588626,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{83.9161664928081829050045847605169987244,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{45.3962072828509006659554747263057746425,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{55.71266414560061755169874885307589448,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{5.12371111633015802258925035541449106027,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{67.906675018409092977390977145838176402,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{2.5794391005383662257508074595648236693,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.0386895600034296405860185848319511351,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.45125859755490762107439667281139062596,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.1843347162225632381893919230709888387,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.4032209503142148825680105325483863196,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{67.5023787493602657166305009192897025337,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{66.1049560098642322849504284562036977149,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{96.1725297693740408539300763848398284444,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{478.306712587881635733239450856994272888,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{41.1800819318607010138415742298409875195,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{57.1589618502180200260606429210472407586,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{34.6393397469693861352033040628017446384,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{107.540836892212976967353436658685182471,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.60835280830643087454733276835326670594,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.75619126739459129641981691708597899173,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.3578562413286597302571301005032342881,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{2.18487434942845799548954881780417934257,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.71270407452223080338768741819465640374,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.0092318068797658899662060475630369986,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{1.47957464450968812690498349033726733061,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.7342596868940815328165568246857386203,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.45518187161387050136339152931999482486,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{46.2249814417658109192935749541717330226,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{18.3040381602645467051188735675958071014,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.9813350507430273671022106451797617264,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.12307300361629325719841470856228218668,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{6.45841707780413817881572766807616817452,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.7895271538099089096667853391238654292,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.3886461374608819168064691059654676622,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.21715892675027165232171735483780701645,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.81257179985269458788733510121837905042,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.0032076828177426713345727926918483851,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{17.6578007679254623391416237970239668665,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.00377338942800318137161591122503401677,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{58.1449600160559307037669585821271837147,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{.745572544165275194033411679293737314112,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.5059102398952868043793990122267834982,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.84564037867025591003708247043651162775,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{39.7034805394505296425815363466548137183,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.6638024138441180980430061526721812941,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.03441066609526779048740916306325481454,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{13.7342814690243049876941046289205634867,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{101.824247223989134172314474159905000286,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.5151783151398347933033540494757153811,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{64.4941237410399709988806381787516098018,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.44532300902351160816899725289200852996,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.9098741094849583193653279559115571441,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{65.2352629093807605051301584879222316576,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.3783361863253860573189248826882830739,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.3783361863253860573189248826882830739,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.249721242572197965770060043987671476,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.2254702999026358128109676037379900343,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.6062202570243163704355796414760951781,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.4352927259489344833421960726159771289,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.7382518823630307898002356190690203744,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.60127278515750686982727445986686729744,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.71644058930274138195997161744980690562,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.5289815390498833505444149356003961996,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{26.9311315271126903321978886683131377621,1,0}, new double[]{1}));
    	dataList.add(new Data(new double[]{20.6179979082160738887533390753396444651,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.86126650372119176672919010295522219086,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.37811397965457145692197244795839543387,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.04177685885810974292893970303556104137,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.86947365002084156906301363435551789083,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.10597295714332549226426305134682072398,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{32.4781540343795900866682201172187901842,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{6.31126618102219516482872059618169592595,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.56672303545979366545838630574006439533,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.28697326340905442305315186540782776209,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{196.297490877138252191616551683788841255,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.7765668102566035629640423016699045704,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.19026611635370694173494815899251063602,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.0436980179941295697366082569808537585,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.0293752960637069305654959716199094791,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.1637998575707289965006058230563834002,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.14933795793095323417942949563639134608,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.83282493314626437582158254741961911686,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{11.1774999456825918384714704180811748844,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.9381841660817389323940853322366178318,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.14545956038585454124647309057450234788,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{26.2892923861388506393280115326659104262,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.0705162640310054169151695335602514911,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.09979256149655749257845079982755536177,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.7768909743106080654834004487250563678,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.86818677747103322851416189104916437089,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{19.9152738616982406329180015032041789293,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.0604056340946114941534797738129883307,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{35.4876642927880493599250352005058875737,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{9367.24196692687237655570321877581112024,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.19714929893415913575806151622504132117,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{44.1401380291172959910019772585314078413,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.4844583145216176541083496706918884516,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{14.8853299642848795668364112031053568384,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{15.5422804693617222649349936248923408807,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.99888247585783119952297468346261675643,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{6.48201756079077031461450655110132461051,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{58.00365249583952944250981201842502416,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.3763664466187221861353832916621066146,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.3245022368206574347279404407248259144,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{37.3088238544053350718954853344110756515,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{8.51854836609437902114312145358972297868,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{8.31099347498111257068533161144510148038,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.4792136989754081802144295651847391775,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.5749086301894695786763427176166837827,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.5769469471706109550031531328832783703,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.9783183450521950243813903717100438968,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{82.9455549266122169539591508270891915575,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.9356718806730637067964232409798944198,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.17656907660527275548638589920276295203,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{28.5891438552550850850654752606644588594,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.08401728565324837269011016062605254505,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{28.0802369605499967443378934963483096132,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{413.614761071644312843847781458329180189,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{15.0029479307766782479887299102429667358,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.9325284826980393195326070344691394788,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.02450459547440615457072187981161678267,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.78813360684731873816188471855642531753,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{12.5399179344287999441174281513811105197,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{227.446850912083884013952359171010755117,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{158.369340623437142324553381384190417094,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{40.7269538206960133286999804366138868427,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.0096322032581470423601792830824836105,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{12.4102005600510568908717230597142303637,1,1}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.9574969330600847840779088321518818613,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{10.3066159463579860814356387453729179142,1,2}, new double[]{1}));
    	dataList.add(new Data(new double[]{9.09488120832938077996011228702027495328,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.5401777814315041192970061892329245098,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.4257798305157978900620391416202127887,1,1}, new double[]{1}));
    	dataList.add(new Data(new double[]{5.64048289840387936373271451025192381557,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{3.44089854876404938403242914176130920186,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{26.2595582908201049404423275198363181113,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{29.4601058512080575937535080278253537056,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{76.0046825368196893418045692057786854538,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{7.48104583151673874382448390857352285051,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{9.48625671499427176010378727775144605477,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{17.9489230754294489781523304216996294992,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{4.5334705165761689728919920830453350827,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{22.7777609281878559570298866632178228137,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.50135282081415437893032859704655134109,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{33.4157728535064974815280158713440661413,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{20.6643283019793904495878002268718208232,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{9.12180170452186640922095712771518359404,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{11.5107332407466892152987019256811776121,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{653.775333581192715552142996150746852902,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{19.8315061687790060245859021430130560431,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{127.864598741131474048451937338039882014,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{506.566718273064707993955639117954916805,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{1.09273064919446896636872471675111756341,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{246.735807370526379602499335273724897091,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{189.902257256435152716165533743874123931,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{45.6539262071637284858735129287583150935,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.19636943780736475256348401903338174651,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{25.1622559678080391609543099991654158479,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{24.0330999625489284180413909965660704553,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{26.7382165147224579981794740973848085322,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{16.6420735201404321391631252435277235502,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{23.1154149131548404329892752688057171743,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{32.9479106328383771206422768955947785672,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{30.0118551772626824422902562442427689038,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{44.651110883000482323973897461446415197,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{33.4994457427011947975589908469847952095,1,0}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.5250049756593674005320536970021938076,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{62.7514892064957060559111705866238131618,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{21.5250049756593674005320536970021938076,1,3}, new double[]{1}));
    	dataList.add(new Data(new double[]{24.3314041676244536840870687664853088552,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{59.7027129192071834039914203194331817067,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{2.88418295448053258372294754882133673777,1,2}, new double[]{0}));
    	dataList.add(new Data(new double[]{18.8364566773078309300573472835284182652,1,3}, new double[]{0}));
    	dataList.add(new Data(new double[]{5.41427510229167815110148412453366565879,1,3}, new double[]{0}));
        if (this.useSimplifiedTrainingData) {
        	dataList = getSimplifiedTrainingData();
        }
        datas = dataList.toArray(new Data[0]);
        calcAverages();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Data next() {
        return datas[(int) (Math.random() * datas.length)];
    }

    @Override
    public Iterator<Data> iterator() {
        return this;
    }

    public void calcAverages() {
    	Arrays.asList(datas).forEach(it -> {
    		double d = it.getInput()[0];
    		double result = it.getResult()[0];
    		if (result == 0) {
    			avgAbgelehnt = avgAbgelehnt + d;
    			countAbgelehnt++;
    		} else {
    			avgAngenommen = avgAngenommen + d;
    			countAngenommen++;
    		}
    	});
    	avgAngenommen = avgAngenommen / datas.length;
    	avgAbgelehnt = avgAbgelehnt / datas.length;
    }
}
