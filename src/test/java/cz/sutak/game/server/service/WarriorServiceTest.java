package cz.sutak.game.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cz.sutak.game.client.bo.User;
import cz.sutak.game.client.dto.WarriorDto;
import cz.sutak.game.client.service.UserService;
import cz.sutak.game.client.service.WarriorService;

public class WarriorServiceTest extends AbstractServiceTest {

        @Autowired
        private UserService us;

        @Autowired
        private WarriorService ws;

        public WarriorServiceTest() {
                super();
        }

        @Test
        public void testGetAllWarriors() {
                Long id = us.addUser("sutak.jakub", "p1");

                ws.addWarrior("fighter", id);
                ws.addWarrior("esuba", id);
                ws.addWarrior("low-klan", id);

                List<WarriorDto> warriors = ws.getAllWarriors();
                assertEquals(3, warriors.size());
        }

        @Test
        public void testGetUserByWarriorName() {
                Long id = us.addUser("sutak.jakub", "p2");
                Long idWar = ws.addWarrior("fighter", id);

                WarriorDto war = ws.getWarriorByName("fighter");
                assertEquals("fighter", war.getName());
                assertEquals(idWar, war.getId());

                User user = war.getUser();
                assertEquals(id, user.getId());
        }

        @Test
        public void testGetWarriorById() {
                Long id = us.addUser("sutak.jakub", "p3");
                ws.addWarrior("fighter", id);
                Long idWar = ws.addWarrior("esuba", id);
                ws.addWarrior("low-klan", id);

                WarriorDto warrior = ws.getWarriorById(idWar);
                assertEquals(idWar, warrior.getId());
        }

        @Test
        public void testGetWarriorByName() {
                Long id = us.addUser("sutak.jakub", "p4");
                ws.addWarrior("fighter", id);
                ws.addWarrior("esuba", id);

                WarriorDto war = ws.getWarriorByName("esuba");
                assertEquals("esuba", war.getName());
        }

        @Test
        public void testAddWarrior() {
                Long id = us.addUser("sutak.jakub", "123456789");

                ws.addWarrior(null, id);
                ws.addWarrior("esuba", null);
                ws.addWarrior(null, null);
                ws.addWarrior("fighter", id);
                Long idWar = ws.addWarrior("esuba", id);

                WarriorDto war = ws.getWarriorById(idWar);
                assertEquals(idWar, war.getId());
        }

        @Test
        public void testRemoveWarrior() {
                Long id = us.addUser("sutak.jakub", "p5");
                
                Long idWar = ws.addWarrior("fighter", id);
                ws.addWarrior("esuba", id);
                
                List<WarriorDto> warriors = ws.getAllWarriors();
                assertEquals(2, warriors.size());

                ws.removeWarrior(idWar);
                List<WarriorDto> warriorsAfterRemove = ws.getAllWarriors();
                assertEquals(1, warriorsAfterRemove.size());
                
                assertNull(ws.getWarriorById(idWar));
        }

        @Test
        public void testEditWarriorsName() {
                Long id = us.addUser("sutak.jakub", "p6");
                ws.addWarrior("fighter", id);
                Long idWar = ws.addWarrior("esuba", id);

                assertEquals("esuba", ws.getWarriorById(idWar).getName());

                ws.editWarriorsName(idWar, "newName");
                assertEquals("newName", ws.getWarriorById(idWar).getName());
        }

        @Test
        public void testEditPoints() {
                Long id = us.addUser("sutak.jakub", "p7");
                Long idWar = ws.addWarrior("noName", id);
                
                WarriorDto war = ws.getWarriorById(idWar);
                assertEquals(new Integer(0), war.getAgility());
                assertEquals(new Integer(0), war.getStrenght());
                assertEquals(new Integer(0), war.getDefense());
                assertEquals(new Integer(0), war.getIntelligence());
                assertEquals(new Integer(10), war.getExtraPoint());

                ws.editPoints(idWar, new Integer(5), new Integer(8), new Integer(4),
                                new Integer(1), new Integer(9));
                war = ws.getWarriorById(idWar);
                
                assertEquals(new Integer(9), war.getAgility());
                assertEquals(new Integer(8), war.getStrenght());
                assertEquals(new Integer(4), war.getDefense());
                assertEquals(new Integer(1), war.getIntelligence());
                assertEquals(new Integer(5), war.getExtraPoint());

                assertNull(ws.editPoints(idWar, null, null, new Integer(5), new Integer(5), new Integer(5)));
                assertNull(ws.editPoints(idWar, null, null, null, null, null));
        }

}