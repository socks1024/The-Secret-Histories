package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Actions.UniqueCards.NewSpawnMonsterAction;
import TheSecretHistories.Content.Actions.UniqueCards.killMonsterVisuallySilentAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.beyond.*;
import com.megacrit.cardcrawl.monsters.city.*;
import com.megacrit.cardcrawl.monsters.ending.CorruptHeart;
import com.megacrit.cardcrawl.monsters.exordium.*;

import java.util.Objects;
import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class SpiritGrailEdge extends AbstractSpirit {

    public static final String ID = StringUtils.MakeID(SpiritGrailEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_graile_edge";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final PrincipleUtils.ReducePrincipleInfo[] INFOS = new PrincipleUtils.ReducePrincipleInfo[]{
            new PrincipleUtils.ReducePrincipleInfo(KNOCK, 2),
            new PrincipleUtils.ReducePrincipleInfo(GRAIL, 14),
            new PrincipleUtils.ReducePrincipleInfo(FORGE, 6),
    };

    public SpiritGrailEdge() {
        super(ID, IMG_NAME, COST, TYPE, TARGET, INFOS);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        if (Objects.equals(m.id, "AwakenedOne")) {
            if (m.hasPower("Unawakened")) {
                addToBot(new killMonsterVisuallySilentAction(m));
            } else {
                addToBot(new NewSpawnMonsterAction(GetRandomMonster(m), false));
                addToBot(new killMonsterVisuallySilentAction(m));
            }
        } else {
            addToBot(new NewSpawnMonsterAction(GetRandomMonster(m), false));
            addToBot(new SuicideAction(m, false));
        }
    }

    private AbstractMonster GetRandomMonster(AbstractMonster lastMonster) {

        float x = (lastMonster.drawX - Settings.WIDTH * 0.75F) / Settings.xScale;
        float y = (lastMonster.drawY - AbstractDungeon.floorY) / Settings.yScale;

        Random r = new Random();

        AbstractMonster monster;

        float f = new Random().nextFloat();

        if (f < 0.001f) {
            monster = new CorruptHeart();
        } else if (f < 0.2f) {
            AbstractMonster[] ms = new AbstractMonster[] {

                    new Spiker(x,y),
                    new Repulsor(x,y),
                    new Exploder(x,y),
                    new OrbWalker(x,y),
                    new Maw(x,y),
                    new Darkling(x,y),
                    new WrithingMass(),
                    new SpireGrowth(),
                    new Spiker(x,y),
                    new Repulsor(x,y),
                    new Exploder(x,y),
                    new OrbWalker(x,y),
                    new Maw(x,y),
                    new Darkling(x,y),
                    new WrithingMass(),
                    new SpireGrowth(),
                    new Spiker(x,y),
                    new Repulsor(x,y),
                    new Exploder(x,y),
                    new OrbWalker(x,y),
                    new Maw(x,y),
                    new Darkling(x,y),
                    new WrithingMass(),
                    new SpireGrowth(),



//                    new SpireShield(),//
//                    new SpireSpear(),//
//                    new Transient(),
                    new GiantHead(),
                    new Reptomancer(),
                    new Nemesis(),
                    new GiantHead(),
                    new Reptomancer(),
                    new Nemesis(),

                    new Deca(),
                    new Donu(),
                    new AwakenedOne(x,y),
                    new TimeEater(),

            };

            monster = ms[r.nextInt(ms.length)];
        } else if (f < 0.5f) {
            AbstractMonster[] ms = new AbstractMonster[] {
                    new Chosen(x,y),
                    new SphericGuardian(x,y),
                    new Centurion(x,y),
                    new Healer(x,y),
                    new ShelledParasite(x,y),
                    new Snecko(x,y),
                    new Looter(x,y),
                    new Mugger(x,y),
                    new Byrd(x,y),
                    new SnakePlant(x,y),
                    new Chosen(x,y),
                    new SphericGuardian(x,y),
                    new Centurion(x,y),
                    new Healer(x,y),
                    new ShelledParasite(x,y),
                    new Snecko(x,y),
                    new Looter(x,y),
                    new Mugger(x,y),
                    new Byrd(x,y),
                    new SnakePlant(x,y),
                    new Chosen(x,y),
                    new SphericGuardian(x,y),
                    new Centurion(x,y),
                    new Healer(x,y),
                    new ShelledParasite(x,y),
                    new Snecko(x,y),
                    new Looter(x,y),
                    new Mugger(x,y),
                    new Byrd(x,y),
                    new SnakePlant(x,y),

                    new Taskmaster(x,y),
                    new GremlinLeader(),
                    new BookOfStabbing(),
                    new Taskmaster(x,y),
                    new GremlinLeader(),
                    new BookOfStabbing(),

                    new BronzeAutomaton(),
                    new TheCollector(),
                    new Champ(),
            };

            monster = ms[r.nextInt(ms.length)];
        } else {
            AbstractMonster[] ms = new AbstractMonster[] {
                    new Cultist(x,y),
                    new JawWorm(x,y),
                    new AcidSlime_L(x,y),
                    new AcidSlime_M(x,y),
                    new AcidSlime_S(x,y,0),
                    new SpikeSlime_L(x,y),
                    new SpikeSlime_M(x,y),
                    new SpikeSlime_S(x,y,0),
                    new GremlinFat(x,y),
                    new GremlinWizard(x,y),
                    new GremlinWarrior(x,y),
                    new GremlinThief(x,y),
                    new GremlinTsundere(x,y),
                    new LouseNormal(x,y),
                    new LouseDefensive(x,y),
                    new SlaverRed(x,y),
                    new SlaverBlue(x,y),
                    new FungiBeast(x,y),
                    new Cultist(x,y),
                    new JawWorm(x,y),
                    new AcidSlime_L(x,y),
                    new AcidSlime_M(x,y),
                    new AcidSlime_S(x,y,0),
                    new SpikeSlime_L(x,y),
                    new SpikeSlime_M(x,y),
                    new SpikeSlime_S(x,y,0),
                    new GremlinFat(x,y),
                    new GremlinWizard(x,y),
                    new GremlinWarrior(x,y),
                    new GremlinThief(x,y),
                    new GremlinTsundere(x,y),
                    new LouseNormal(x,y),
                    new LouseDefensive(x,y),
                    new SlaverRed(x,y),
                    new SlaverBlue(x,y),
                    new FungiBeast(x,y),
                    new Cultist(x,y),
                    new JawWorm(x,y),
                    new AcidSlime_L(x,y),
                    new AcidSlime_M(x,y),
                    new AcidSlime_S(x,y,0),
                    new SpikeSlime_L(x,y),
                    new SpikeSlime_M(x,y),
                    new SpikeSlime_S(x,y,0),
                    new GremlinFat(x,y),
                    new GremlinWizard(x,y),
                    new GremlinWarrior(x,y),
                    new GremlinThief(x,y),
                    new GremlinTsundere(x,y),
                    new LouseNormal(x,y),
                    new LouseDefensive(x,y),
                    new SlaverRed(x,y),
                    new SlaverBlue(x,y),
                    new FungiBeast(x,y),

                    new GremlinNob(x,y),
                    new Lagavulin(false),
                    new Sentry(x,y),
                    new GremlinNob(x,y),
                    new Lagavulin(false),
                    new Sentry(x,y),

                    new TheGuardian(),
                    new Hexaghost(),
                    new SlimeBoss(),
            };

            monster = ms[r.nextInt(ms.length)];
        }

        if (Objects.equals(monster.name, lastMonster.name)) {
            monster = GetRandomMonster(lastMonster);
        }

        if (this.upgraded) {
            float ratio = (float) lastMonster.currentHealth / lastMonster.maxHealth;
            monster.currentHealth = (int) (monster.maxHealth * ratio);
            monster.healthBarUpdatedEvent();
        }

        return monster;
    }

    public void OnUpgrade(int timesUpgraded) {

    }

}
