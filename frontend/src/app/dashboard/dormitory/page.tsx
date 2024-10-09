import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"

export default function DormitoryPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Dormitory</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Assign Room</CardTitle>
          <CardDescription className="text-gray-600">Assign a student to a dormitory room.</CardDescription>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <Input className="bg-white text-black border-gray-300" placeholder="Student Name" />
            <Select>
              <SelectTrigger className="w-full bg-white text-black border-gray-300">
                <SelectValue placeholder="Select Dormitory" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="dorm1">Dormitory 1</SelectItem>
                <SelectItem value="dorm2">Dormitory 2</SelectItem>
                <SelectItem value="dorm3">Dormitory 3</SelectItem>
              </SelectContent>
            </Select>
            <Input className="bg-white text-black border-gray-300" placeholder="Room Number" />
            <Button className="bg-blue-600 text-white hover:bg-blue-700">Assign Room</Button>
          </form>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Room Assignments</CardTitle>
          <CardDescription className="text-gray-600">View current room assignments.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">John Doe - Dormitory 1, Room 101</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Edit</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Jane Smith - Dormitory 2, Room 202</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Edit</Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}